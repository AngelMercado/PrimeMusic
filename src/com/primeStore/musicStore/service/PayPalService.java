package com.primeStore.musicStore.service;

import java.io.IOException;

import com.primeStore.musicStore.domain.Cart;

public interface PayPalService {
	
	
	public String createPayment(Cart cart) throws IOException;
}
