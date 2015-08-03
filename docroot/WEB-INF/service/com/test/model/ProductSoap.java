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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.test.service.http.ProductServiceSoap}.
 *
 * @author Michael
 * @see com.test.service.http.ProductServiceSoap
 * @generated
 */
public class ProductSoap implements Serializable {
	public static ProductSoap toSoapModel(Product model) {
		ProductSoap soapModel = new ProductSoap();

		soapModel.setProductId(model.getProductId());
		soapModel.setProductName(model.getProductName());
		soapModel.setWeight(model.getWeight());
		soapModel.setManufactureDate(model.getManufactureDate());
		soapModel.setDateOfSale(model.getDateOfSale());
		soapModel.setBakerName(model.getBakerName());
		soapModel.setPrice(model.getPrice());
		soapModel.setOffice(model.getOffice());

		return soapModel;
	}

	public static ProductSoap[] toSoapModels(Product[] models) {
		ProductSoap[] soapModels = new ProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[][] toSoapModels(Product[][] models) {
		ProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[] toSoapModels(List<Product> models) {
		List<ProductSoap> soapModels = new ArrayList<ProductSoap>(models.size());

		for (Product model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductSoap[soapModels.size()]);
	}

	public ProductSoap() {
	}

	public long getPrimaryKey() {
		return _productId;
	}

	public void setPrimaryKey(long pk) {
		setProductId(pk);
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public String getProductName() {
		return _productName;
	}

	public void setProductName(String productName) {
		_productName = productName;
	}

	public int getWeight() {
		return _weight;
	}

	public void setWeight(int weight) {
		_weight = weight;
	}

	public Date getManufactureDate() {
		return _manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		_manufactureDate = manufactureDate;
	}

	public Date getDateOfSale() {
		return _dateOfSale;
	}

	public void setDateOfSale(Date dateOfSale) {
		_dateOfSale = dateOfSale;
	}

	public String getBakerName() {
		return _bakerName;
	}

	public void setBakerName(String bakerName) {
		_bakerName = bakerName;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public String getOffice() {
		return _office;
	}

	public void setOffice(String office) {
		_office = office;
	}

	private long _productId;
	private String _productName;
	private int _weight;
	private Date _manufactureDate;
	private Date _dateOfSale;
	private String _bakerName;
	private double _price;
	private String _office;
}