package com.primeStore.musicStore.dao;

import com.primeStore.musicStore.domain.Cart;

public interface CartDao {
	
	Cart createCart(Cart cart);
	Cart read(String cartId);
	void updateCart(String cartId,Cart cart);
	void delete(String cartId);
	
}
