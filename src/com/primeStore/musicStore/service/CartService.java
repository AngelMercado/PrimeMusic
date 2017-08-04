package com.primeStore.musicStore.service;

import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;

public interface CartService {

	Cart getCartById(int cartId);
	void updateCart(Cart cart);
	

}
