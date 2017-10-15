package com.primeStore.musicStore.service;

import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;

public interface CartItemService {
	void addCartItem(CartItem cartItem);

	void removeCartItem(CartItem cartItem);

	void removeAllCartItems(Cart cart);

	CartItem getCartItemByProductId(int productId);
}
