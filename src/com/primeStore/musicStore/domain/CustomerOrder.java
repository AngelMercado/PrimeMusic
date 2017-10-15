package com.primeStore.musicStore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int customerOrderId;
	
	@OneToOne
	@JoinColumn(name="idCart")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="idCustomer")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="idBillingAddress")
	private BillingAddress billingAddress;	
	
	@OneToOne
	@JoinColumn(name="idShippingAddress")
	private ShippingAddress shippingAddress;

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
