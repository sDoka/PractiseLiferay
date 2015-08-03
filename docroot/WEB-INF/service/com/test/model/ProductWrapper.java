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

package com.test.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author Michael
 * @see Product
 * @generated
 */
public class ProductWrapper implements Product, ModelWrapper<Product> {
	public ProductWrapper(Product product) {
		_product = product;
	}

	@Override
	public Class<?> getModelClass() {
		return Product.class;
	}

	@Override
	public String getModelClassName() {
		return Product.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productId", getProductId());
		attributes.put("productName", getProductName());
		attributes.put("weight", getWeight());
		attributes.put("manufactureDate", getManufactureDate());
		attributes.put("dateOfSale", getDateOfSale());
		attributes.put("bakerName", getBakerName());
		attributes.put("price", getPrice());
		attributes.put("office", getOffice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		Integer weight = (Integer)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Date manufactureDate = (Date)attributes.get("manufactureDate");

		if (manufactureDate != null) {
			setManufactureDate(manufactureDate);
		}

		Date dateOfSale = (Date)attributes.get("dateOfSale");

		if (dateOfSale != null) {
			setDateOfSale(dateOfSale);
		}

		String bakerName = (String)attributes.get("bakerName");

		if (bakerName != null) {
			setBakerName(bakerName);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String office = (String)attributes.get("office");

		if (office != null) {
			setOffice(office);
		}
	}

	/**
	* Returns the primary key of this product.
	*
	* @return the primary key of this product
	*/
	@Override
	public long getPrimaryKey() {
		return _product.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product.
	*
	* @param primaryKey the primary key of this product
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_product.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the product ID of this product.
	*
	* @return the product ID of this product
	*/
	@Override
	public long getProductId() {
		return _product.getProductId();
	}

	/**
	* Sets the product ID of this product.
	*
	* @param productId the product ID of this product
	*/
	@Override
	public void setProductId(long productId) {
		_product.setProductId(productId);
	}

	/**
	* Returns the product name of this product.
	*
	* @return the product name of this product
	*/
	@Override
	public java.lang.String getProductName() {
		return _product.getProductName();
	}

	/**
	* Sets the product name of this product.
	*
	* @param productName the product name of this product
	*/
	@Override
	public void setProductName(java.lang.String productName) {
		_product.setProductName(productName);
	}

	/**
	* Returns the weight of this product.
	*
	* @return the weight of this product
	*/
	@Override
	public int getWeight() {
		return _product.getWeight();
	}

	/**
	* Sets the weight of this product.
	*
	* @param weight the weight of this product
	*/
	@Override
	public void setWeight(int weight) {
		_product.setWeight(weight);
	}

	/**
	* Returns the manufacture date of this product.
	*
	* @return the manufacture date of this product
	*/
	@Override
	public java.util.Date getManufactureDate() {
		return _product.getManufactureDate();
	}

	/**
	* Sets the manufacture date of this product.
	*
	* @param manufactureDate the manufacture date of this product
	*/
	@Override
	public void setManufactureDate(java.util.Date manufactureDate) {
		_product.setManufactureDate(manufactureDate);
	}

	/**
	* Returns the date of sale of this product.
	*
	* @return the date of sale of this product
	*/
	@Override
	public java.util.Date getDateOfSale() {
		return _product.getDateOfSale();
	}

	/**
	* Sets the date of sale of this product.
	*
	* @param dateOfSale the date of sale of this product
	*/
	@Override
	public void setDateOfSale(java.util.Date dateOfSale) {
		_product.setDateOfSale(dateOfSale);
	}

	/**
	* Returns the baker name of this product.
	*
	* @return the baker name of this product
	*/
	@Override
	public java.lang.String getBakerName() {
		return _product.getBakerName();
	}

	/**
	* Sets the baker name of this product.
	*
	* @param bakerName the baker name of this product
	*/
	@Override
	public void setBakerName(java.lang.String bakerName) {
		_product.setBakerName(bakerName);
	}

	/**
	* Returns the price of this product.
	*
	* @return the price of this product
	*/
	@Override
	public double getPrice() {
		return _product.getPrice();
	}

	/**
	* Sets the price of this product.
	*
	* @param price the price of this product
	*/
	@Override
	public void setPrice(double price) {
		_product.setPrice(price);
	}

	/**
	* Returns the office of this product.
	*
	* @return the office of this product
	*/
	@Override
	public java.lang.String getOffice() {
		return _product.getOffice();
	}

	/**
	* Sets the office of this product.
	*
	* @param office the office of this product
	*/
	@Override
	public void setOffice(java.lang.String office) {
		_product.setOffice(office);
	}

	@Override
	public boolean isNew() {
		return _product.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_product.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _product.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_product.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _product.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _product.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_product.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _product.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_product.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_product.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_product.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductWrapper((Product)_product.clone());
	}

	@Override
	public int compareTo(com.test.model.Product product) {
		return _product.compareTo(product);
	}

	@Override
	public int hashCode() {
		return _product.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.test.model.Product> toCacheModel() {
		return _product.toCacheModel();
	}

	@Override
	public com.test.model.Product toEscapedModel() {
		return new ProductWrapper(_product.toEscapedModel());
	}

	@Override
	public com.test.model.Product toUnescapedModel() {
		return new ProductWrapper(_product.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _product.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _product.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_product.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductWrapper)) {
			return false;
		}

		ProductWrapper productWrapper = (ProductWrapper)obj;

		if (Validator.equals(_product, productWrapper._product)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Product getWrappedProduct() {
		return _product;
	}

	@Override
	public Product getWrappedModel() {
		return _product;
	}

	@Override
	public void resetOriginalValues() {
		_product.resetOriginalValues();
	}

	private Product _product;
}