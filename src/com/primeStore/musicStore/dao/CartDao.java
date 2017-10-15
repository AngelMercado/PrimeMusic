package com.primeStore.musicStore.dao;

import java.io.IOException;

import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;

public interface CartDao {
	
	void update(Cart cart);
	Cart getCartById(int idCart);
	
	Cart validate(int cartId) throws IOException;
	
}
