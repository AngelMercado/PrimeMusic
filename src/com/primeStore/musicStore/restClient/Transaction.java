package com.primeStore.musicStore.restClient;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Transaction{
	private MultiValueMap<String, String> amount = new LinkedMultiValueMap<String, String>();
	
	public Transaction() {}
	public void setAmount(String total, String currency) {
		this.amount.add("total", total);
		
	}

	public MultiValueMap<String, String> getAmount() {
		return amount;
	}
	
}
