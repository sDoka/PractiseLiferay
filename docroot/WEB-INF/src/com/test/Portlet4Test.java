package com.test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


















import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.test.model.Product;
import com.test.service.ProductLocalServiceUtil;
import com.test.service.impl.ProductLocalServiceImpl;


/**
 * Portlet implementation class Portlet4Test
 */

public class Portlet4Test extends MVCPortlet {

		public static final String VIEW_JSP = "/html/portlet4test/view.jsp";
		public static final String VIEW_PAGE = "viewPage";
		public static final String ADDPRODUCT_JSP = "/html/portlet4test/addProduct.jsp";
		public static final String ADDPRODUCT_PAGE = "addProductPage";
		public static final String EDIT_JSP = "/html/portlet4test/addProduct.jsp";
		public static final String EDIT_PAGE = "editProductPage";
		public static final String PAGE_PARAM = "mvcPath";
		public static final String[] OFFICES = {"Moon","Earth","Venus"};
		public static final String[] POWER_ROLES = {"Manager","Organization Owner"};
		

	
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
	/*	try {
			long userId =  themeDisplay.getUser().getUserId();
			System.out.println("User Id is : " + userId);
			
			
			getOrganizationRoles();//------------------------------------------------------------------
			
			System.out.println(checkPermissions(themeDisplay.getUser()));
			
			
		} catch (SystemException  e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	
		
		String pageParam = ParamUtil.getString(request, PAGE_PARAM, VIEW_PAGE);

		if (VIEW_PAGE.equals(pageParam)) {
			List<Product> products = new ArrayList<Product>();
			Product product;
			try {
				if (!themeDisplay.getUser().isDefaultUser()){
					Boolean permission = checkPermissions(themeDisplay.getUser());//check out for permissions
					request.setAttribute("permission", permission);
				} else {
					request.setAttribute("permission", false);
				}

				
				products = ProductLocalServiceUtil.getProducts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);//getAllProducts List

			} catch (SystemException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("allProducts", products);
			response.setTitle("Products");
			
			include(VIEW_JSP, request, response);
			
		} else if (ADDPRODUCT_PAGE.equals(pageParam)) {
			//System.out.println("addProductPage");
			request.setAttribute("offices", OFFICES);
			include(ADDPRODUCT_JSP, request, response);
			
			
		} else if (EDIT_PAGE.equals(pageParam)) {//open addProduct page with edit request
			Product productToEdit = null; //how can i initialize it another way?
			
			
			try{
				long pId = ParamUtil.getLong(request,"id");//--------------------------------------
				//System.out.println(id);
				productToEdit = ProductLocalServiceUtil.getProduct(pId);//TODO getProduct
				//System.out.println(productToEdit.getPrimaryKey());
			} catch (SystemException | PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("productToEdit", productToEdit);
			request.setAttribute("offices", OFFICES);
			request.setAttribute("currentOffice", productToEdit.getOffice());
			response.setTitle("EditProduct");
			
			
			include(EDIT_JSP, request, response);
		}
		
		
		
	}
	public void addProduct(ActionRequest request, ActionResponse response)
			throws PortletException, IOException, SystemException, PortalException {
		
		String productName = ParamUtil.getString(request,"pName");
		int productWeight = ParamUtil.getInteger(request, "pWeight");
		String backerName = ParamUtil.getString(request,"pBakerName");
		double productPrice = ParamUtil.getDouble(request, "pPrice");
		String office = ParamUtil.getString(request,"pOffice");
		long productId = ParamUtil.getLong(request, "pId");
		System.out.println(productId);
		if (productId==0)
		{
			 Product newProduct = ProductLocalServiceUtil.addProduct(productName, productWeight, backerName, productPrice,office);
		}
		//add product every time with page refresh... wtf?
		else {
			Product productToEdit = ProductLocalServiceUtil.getProduct(productId);
			productToEdit.setProductName(productName);
			productToEdit.setWeight(productWeight);
			productToEdit.setBakerName(backerName);
			productToEdit.setPrice(productPrice);
			productToEdit.setOffice(office);
			ProductLocalServiceUtil.updateProduct(productToEdit);
		}
	
	}
	
	public void removeProduct(ActionRequest request, ActionResponse response)
			throws PortletException, IOException, SystemException, PortalException {
		long pId = ParamUtil.getLong(request,"id");
		ProductLocalServiceUtil.deleteProduct(pId);// getId from viewJSP
		
	}
	
	/*public void getOrganizationRoles()//use it 2 see all organization roles
	{
		//organization roles have type 3
		int type = 3;
		String subtype = StringPool.BLANK;
		try{
			List<Role> organizationRoles = RoleLocalServiceUtil.getRoles(type, subtype);
			Iterator<Role> roleIterator = organizationRoles.iterator();
			while(roleIterator.hasNext()){
				Role organizationRole = roleIterator.next();
				System.out.println("organizationRole Name " + organizationRole.getName() + "; organizationRoleID: " + organizationRole.getRoleId()); 
			}
		}catch(Exception e){
			//TODO add exception
		}
		
	}
	*/
	public Boolean checkPermissions(User user) throws SystemException, PortalException{//use it 2 check, if user has required permissions
		Boolean editPermission  = false;
			List<UserGroupRole> userOrganizationRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user.getUserId());
			Iterator<UserGroupRole> organizationRoleIterator = userOrganizationRoles.iterator();
			
			while(organizationRoleIterator.hasNext()){
				UserGroupRole organizationRole = organizationRoleIterator.next();
				String roleName = organizationRole.getRole().getName();
				//System.out.println(roleName);
				for(String powerRole : POWER_ROLES){
					if(powerRole.equals(roleName))
						editPermission = true;
				}
			}
			return editPermission;
	} 

}
