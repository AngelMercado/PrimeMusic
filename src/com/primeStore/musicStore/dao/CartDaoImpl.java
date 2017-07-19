package com.primeStore.musicStore.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.primeStore.musicStore.domain.Cart;
@Repository
public class CartDaoImpl implements CartDao{

	private Map<String , Cart> listOfCarts;
	
	public CartDaoImpl() {
		
		listOfCarts= new HashMap<String,Cart>();
	}
	@Override
	public Cart createCart(Cart cart) {
		if (listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Cannot create a cart , a cart with the given id(%d) already exists ",cart.getCartId()));
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);		
	}

	@Override
	public void updateCart(String cartId, Cart cart) {
		if (!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Cannot update a cart , a cart with the given id(%d) does not exists ",cart.getCartId()));
		}
		listOfCarts.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if (!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Cannot delete a cart , a cart with the given id(%d) does not exists ",cartId));
		}
		listOfCarts.remove(cartId);
	}

}
