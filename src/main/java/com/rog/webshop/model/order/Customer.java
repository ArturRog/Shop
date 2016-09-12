package com.rog.webshop.model.order;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = 2284040482222162898L;

	@Size(min = 3, max = 40, message = "{Size.Product.productName.validation}")
	@Column(name = "PRODUCT_NAME")
	private String customerId;

	@Size(min = 4, max = 40, message = "{Size.Product.productName.validation}")
	@Column(name = "PRODUCT_NAME")
	private String name;

	private Address billingAddress;

	@Size(min = 4, max = 40, message = "{Size.Product.productName.validation}")
	@Column(name = "PRODUCT_NAME")
	private String phoneNumber;
	
	public Customer() {
		this.billingAddress = new Address();
	}
	
	public Customer(String customerId, String name) {
		this();
		this.customerId = customerId;
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 853;
		int result = 1;
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}

	
}
