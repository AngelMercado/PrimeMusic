package com.primeStore.musicStore.restClient;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Payment {

	private String intent;
	@JsonIgnore
	private String experience_profile_id;
	
	private MultiValueMap<String, String> redirect_urls= new LinkedMultiValueMap<String, String>();
	private MultiValueMap<String, String> payer= new LinkedMultiValueMap<String, String>();
	private Transaction[] transactions;
	
	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public MultiValueMap<String, String> getRedirect_urls() {
		return redirect_urls;
	}

	public void setRedirect_urls(String return_url ,String cancel_url) {
		this.redirect_urls.add("return_url", return_url);
		this.redirect_urls.add("cancel_url", cancel_url);
	}

	public MultiValueMap<String, String> getPayer() {
		return payer;
	}

	public void setPayer(String payment_method) {
		this.payer.add("payment_method", payment_method);
	}

	

	public String getExperience_profile_id() {
		return experience_profile_id;
	}
	
	public void setExperience_profile_id(String experience_profile_id) {
		this.experience_profile_id = experience_profile_id;
	}
	
	class Transaction{
		private MultiValueMap<String, String> amount = new LinkedMultiValueMap<String, String>();
		
		public Transaction() {}
		public void setAmount(String total, String currency) {
			this.amount.add("total", total);
			
		}

		public MultiValueMap<String, String> getAmount() {
			return amount;
		}
		
	}
	
	
}
