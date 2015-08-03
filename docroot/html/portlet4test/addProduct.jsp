<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@page import="com.test.model.Product"%>
<link href="<%=request.getContextPath() %>/css/editPage.css" rel="stylesheet" type="text/css" />
<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
	
	String productName = "";
	int weight = 0;
	String bakerName = "";
	double price = 0 ;
	String office = "";
	long id = 0;
	
Product productToEdit = (Product)renderRequest.getAttribute("productToEdit");

	if (productToEdit != null ){
		 productName = productToEdit.getProductName();
		 weight = productToEdit.getWeight();
		 bakerName = productToEdit.getBakerName();
		 price = productToEdit.getPrice();
		 office = productToEdit.getOffice();
		 id = productToEdit.getPrimaryKey();
	}


%>





<portlet:actionURL name="addProduct" var="addProductURL">
</portlet:actionURL>

<aui:form action="<%= addProductURL %>" method="post">
    <aui:input label="ProductName" name="pName" type="text" value="<%=productName %>" />
    <aui:input label="Weight" name="pWeight" type="text" value="<%=weight %>" />
    <aui:input label="BakerName" name="pBakerName" type="text" value="<%=bakerName %>" />
    <aui:input label="Price" name="pPrice" type="text" value="<%=price %>" />
    <aui:select label="Office" name="pOffice" type="text" >
    	<c:forEach  items="${offices}" var="office" >
    		<aui:option value="${office}" label="${office}" selected="${currentOffice == office}"/>
    	</c:forEach>
	</aui:select>
	<p></p>
	<aui:input  type="hidden" name="pId" value="<%=id %>"/>
	
    <aui:button type="submit" value="Submit"/>
</aui:form>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="viewPage" />
</portlet:renderURL>

<p><a href="<%= viewURL %>">&larr; Back</a></p>





