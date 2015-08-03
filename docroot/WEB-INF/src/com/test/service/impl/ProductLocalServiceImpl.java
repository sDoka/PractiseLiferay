/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.test.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.test.model.Product;
import com.test.service.ProductLocalServiceUtil;
import com.test.service.base.ProductLocalServiceBaseImpl;

/**
 * The implementation of the product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.test.service.ProductLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Michael
 * @see com.test.service.base.ProductLocalServiceBaseImpl
 * @see com.test.service.ProductLocalServiceUtil
 */
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.test.service.ProductLocalServiceUtil} to access the product local service.
	 */
	
	public Product addProduct(String productName,int weight,String bakerName,double price,String office) throws SystemException
	{
		long id = counterLocalService.increment();
		
		Product product = ProductLocalServiceUtil.createProduct(id);
		product.setWeight(weight);
		product.setProductName(productName);
		product.setBakerName(bakerName);
		product.setOffice(office);
		
		
		Date now = new Date();
		product.setManufactureDate(now);
		
		product.setPrice(price);
		ProductLocalServiceUtil.addProduct(product);
		
		return product;
	
	}
	
	
	public List getProductsByOffice(String office)
	{
		List products = null;
		
		try {
			products = productPersistence.findByOffice(office);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return products;
	}
	
	
	public Boolean deleteProductById(long productId)
	{
		boolean result = false;
		
		try {
			ProductLocalServiceUtil.deleteProduct(productId);
			result = true;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	
	return result;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
}