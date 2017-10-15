package com.primeStore.musicStore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem implements Serializable{
	
	private static final long serialVersionUID = 4521509952778925922L;
	
	@Id
	@GeneratedValue
	private int cartItemId;
	//ManyToOne the firts word refers to the class 
	//JoinColum creates a new field in the table to refers to the cart
	//JsonIgnore exclude the Cart from this cartItem because Cart include the Cartitems 
	@ManyToOne
	@JoinColumn(name="idCart")
	@JsonIgnore
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	private int quatity;
	private double totalPrice;
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuatity() {
		return quatity;
	}
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
