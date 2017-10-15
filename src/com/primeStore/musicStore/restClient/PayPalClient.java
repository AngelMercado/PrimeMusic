package com.primeStore.musicStore.restClient;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface PayPalClient {

	String createToken();
	String createPaymant();
	String executePayment();
}
