package com.primeStore.musicStore.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeStore.musicStore.dao.CartItemDao;
import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemDao cartItemDao;

	@Override
	public void addCartItem(CartItem cartItem) {

		cartItemDao.addCartItem(cartItem);
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		cartItemDao.removeCartItem(cartItem);
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllItems(cart);

	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		
		return cartItemDao.getCartItemByProductId(productId);
	}

}
