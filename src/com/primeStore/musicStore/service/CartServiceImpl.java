package com.primeStore.musicStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeStore.musicStore.dao.CartDao;
import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;
@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao cartDao; 
	@Override
	public Cart getCartById(int cartId) {
		
		return cartDao.getCartById(cartId);
	}

	@Override
	public void updateCart(Cart cart) {
		cartDao.update(cart);
		
	}

	
	

}
