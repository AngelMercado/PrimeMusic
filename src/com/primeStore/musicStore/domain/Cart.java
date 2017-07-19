package com.primeStore.musicStore.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.config.CustomEditorConfigurer;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cart implements Serializable{
	
	private static final long serialVersionUID = 2122044308909281208L;
	
	@Id
	@GeneratedValue
	private int idCart;
	
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<CartItem> cartItems;
	
	@OneToOne
	@JoinColumn(name="idCustomer")
	@JsonIgnore
	private Customer customer;
	
	private double grandTotal;

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
	