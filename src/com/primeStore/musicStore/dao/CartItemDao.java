package com.primeStore.musicStore.dao;

import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;

public interface CartItemDao {

	void addCartItem(CartItem cartItem);
	void removeCartItem(CartItem cartItem);
	void removeAllItems(Cart cart);
	CartItem getCartItemByProductId(int productId);
}
