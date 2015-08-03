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

package com.test.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.test.model.Product;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Product in entity cache.
 *
 * @author Michael
 * @see Product
 * @generated
 */
public class ProductCacheModel implements CacheModel<Product>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{productId=");
		sb.append(productId);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", manufactureDate=");
		sb.append(manufactureDate);
		sb.append(", dateOfSale=");
		sb.append(dateOfSale);
		sb.append(", bakerName=");
		sb.append(bakerName);
		sb.append(", price=");
		sb.append(price);
		sb.append(", office=");
		sb.append(office);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Product toEntityModel() {
		ProductImpl productImpl = new ProductImpl();

		productImpl.setProductId(productId);

		if (productName == null) {
			productImpl.setProductName(StringPool.BLANK);
		}
		else {
			productImpl.setProductName(productName);
		}

		productImpl.setWeight(weight);

		if (manufactureDate == Long.MIN_VALUE) {
			productImpl.setManufactureDate(null);
		}
		else {
			productImpl.setManufactureDate(new Date(manufactureDate));
		}

		if (dateOfSale == Long.MIN_VALUE) {
			productImpl.setDateOfSale(null);
		}
		else {
			productImpl.setDateOfSale(new Date(dateOfSale));
		}

		if (bakerName == null) {
			productImpl.setBakerName(StringPool.BLANK);
		}
		else {
			productImpl.setBakerName(bakerName);
		}

		productImpl.setPrice(price);

		if (office == null) {
			productImpl.setOffice(StringPool.BLANK);
		}
		else {
			productImpl.setOffice(office);
		}

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		productId = objectInput.readLong();
		productName = objectInput.readUTF();
		weight = objectInput.readInt();
		manufactureDate = objectInput.readLong();
		dateOfSale = objectInput.readLong();
		bakerName = objectInput.readUTF();
		price = objectInput.readDouble();
		office = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(productId);

		if (productName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productName);
		}

		objectOutput.writeInt(weight);
		objectOutput.writeLong(manufactureDate);
		objectOutput.writeLong(dateOfSale);

		if (bakerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bakerName);
		}

		objectOutput.writeDouble(price);

		if (office == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(office);
		}
	}

	public long productId;
	public String productName;
	public int weight;
	public long manufactureDate;
	public long dateOfSale;
	public String bakerName;
	public double price;
	public String office;
}