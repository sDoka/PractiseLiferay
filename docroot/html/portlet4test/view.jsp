
<%@page import="java.util.ArrayList"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@page import="java.util.List"%>
<%@page import="com.test.model.Product"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="http://code.jquery.com/jquery-latest.js">  </script>




<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jquery_confirm/jquery_confirm.css" />
<link href='http://fonts.googleapis.com/css?family=Cuprum&amp;subset=cyrillic,latin' rel='stylesheet' type='text/css'>
<link href="<%=request.getContextPath() %>/css/viewPage.css" rel="stylesheet" type="text/css" />


<portlet:defineObjects />
<portlet:renderURL  var="view" windowState="normal">
<portlet:param name="mvcPath" value="viewPage"/>
</portlet:renderURL>

<portlet:renderURL var="addProductURL">
    <portlet:param name="mvcPath" value="addProductPage"/>
</portlet:renderURL>
<portlet:renderURL var="editProductURL">
    <portlet:param name="mvcPath" value="editProductPage"  />
     <portlet:param name="id" value="%YOYO%"  /><%//be carefull with Url encoding! %>
</portlet:renderURL>
	<portlet:actionURL name="removeProduct" var="removeProductURL">
	<portlet:param name="id" value="%YOYO%"  />
</portlet:actionURL>
<%
PortletPreferences prefs = renderRequest.getPreferences();

String productCountString = (String)prefs.getValue(
"productCountString", "Current product's in list ");
//List<Product> products = (ArrayList<Product>) request.getAttribute("allProducts");
Boolean permission = (Boolean)renderRequest.getAttribute("permission");
%>

<p><%= productCountString %></p>


<table style="width: 100%">
 <thead>
	<tr>
  	  <th>Product Name </th>
  	  <th>Baker Name </th>
  	  <th>Product Weight </th>
  	  <th>Product Price $</th>
  	  <th>Office </th>
 </thead>
 <tbody>
	 <c:forEach begin="0" end="${allProducts.size() - 1}" step="1" varStatus="loop">
 	 <tr>
  	  <td >${allProducts.get(loop.index).getProductName()} </td>
  	  <td >${allProducts.get(loop.index).getBakerName()} </td>
  	  <td >${allProducts.get(loop.index).getWeight()} </td>
  	  <td >${allProducts.get(loop.index).getPrice()} </td>
  	  <td >${allProducts.get(loop.index).getOffice()} </td>
  	  <% if (permission) { %>
  	  <td  class = "edit" id ="${allProducts.get(loop.index).getPrimaryKey()}"><img style="float: right;" alt="del" src="<%=request.getContextPath() %>/img/edit.png"></img></td>
  	 <td  class="delete" id ="${allProducts.get(loop.index).getPrimaryKey()}"> <img style="float: left;" alt="del" src="<%=request.getContextPath() %>/img/delete_icon.png"></img> </td>
  	<%} %>
  	</tr>
  	</c:forEach>
  	</tbody>
</table>

<script>
$('td.edit').click(function() {
	event.preventDefault();
	var pId = ($(this).attr("id"));//getting product's id
	 var changedURL = "<%= editProductURL %>".replace("%25YOYO%25",pId); 
	//be carefull with Url encoding!
	window.location.href = changedURL;

});
</script>


 <script>
$('td.delete').click(function(){
	var pId = ($(this).attr("id"));//getting product's id
	var elem = $(this).closest('.item');
	$.confirm({
		'title'		: 'Confirm removing',
		'message'	: 'Do you want to remove this product?',
		'buttons'	: {
			'Accept'	: {
				'class'	: 'blue',
				'action': function(){
					 var changedURL = "<%= removeProductURL %>".replace("%25YOYO%25",pId); 
					//be carefull with Url encoding!
					window.location.href = changedURL;
				}
			},
			'Decline'	: {
				'class'	: 'gray',
				'action': function(){}	//do nothing
			}
		}
	});
});
</script>       
<link href='http://fonts.googleapis.com/css?family=Cuprum&amp;subset=cyrillic,latin' rel='stylesheet' type='text/css'>
<script src="<%=request.getContextPath() %>/js/jquery_confirm/jquery_confirm.js"></script>

 	<a href="<%= addProductURL %>"> Add Product </a> 






