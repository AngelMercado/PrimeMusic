package com.primeStore.musicStore.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4906645703395452998L;
	
	@Id
	@GeneratedValue
	private int idCustomer;
	@NotEmpty(message="customer name must not be null")
	private String customerName;
	@NotEmpty(message="customer email must not be null")
	private String customerEmail;	
	private String customerPhone;
	@NotEmpty(message="the customer username must not be null")
	private String username;
	@NotEmpty(message="the password must not be null")
	private String password;
	private boolean enabled;
	@OneToOne
	@JoinColumn(name="idBillingAddress")
	private BillingAddress billingAddress;
	@OneToOne
	@JoinColumn(name="idShippingAddress")
	private ShippingAddress shippingAddress;
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@OneToOne
	@JoinColumn(name="idCart")
	@JsonIgnore
	private Cart cart;
}
