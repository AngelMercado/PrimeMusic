package com.primeStore.musicStore.restClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



public class PayPalClientImpl implements PayPalClient, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7475202524860360046L;
	private static final String REST_SERVICE_URI = "https://api.sandbox.paypal.com/v1/oauth2/token";
	private static final String PLAIN_CREDENTIALS = "Afz9bcPMFlilFxF0F4M0v56aL-aOIbkHDDxkBymGgegMJ2CrGQ_s0R2qwO2omZNrqGNqmxGx1US4qHyF:EHoTBiDdu9x2fJ-tCxYbIXWyN7qCDo6-T8ybmhR0i5b2K-Fgal6YzzpyJLpeRLkwDFn8mLYWSH-3koK9";
	final static Logger logger = Logger.getLogger(PayPalClientImpl.class);

	public PayPalClientImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String createToken() {
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		MultiValueMap<String, Object[]> transactions = new LinkedMultiValueMap<String, Object[]>();
		HttpEntity<?> httpEntity;

		String base64ClientCredentials = new String(Base64.encode(PLAIN_CREDENTIALS.getBytes()));
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic " + base64ClientCredentials);

		body.add("Content type", "x-www-form-urlencoded");
		body.add("grant_type", "client_credentials");
		

		httpEntity = new HttpEntity<Object>(body, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> responseMap = restTemplate.exchange(REST_SERVICE_URI, HttpMethod.POST, httpEntity,
				Map.class);
		if (responseMap.getStatusCode().value() != 200) {
			logger.debug("Encontered Error while calling Paypal API to generate Token");
			throw new RuntimeErrorException(null, "Encontered Error while calling Paypal API");
		} else {
			return responseMap.getBody().get("access_token").toString();
		}

	}

	@Override
	public String createPaymant() {		
		String token = createToken();
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
		Payment payment = new Payment();
		Transaction transaction = new Transaction();

		transaction.setAmount("1.00", "USD");
		
		payment.setIntent("sale");
		payment.setRedirect_urls("http://www.baeldung.com/jackson-custom-serialization", "cancell");
		payment.setPayer("paypal");
		
		
		HttpEntity<?> httpEntity;
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization","Bearer "+ token);
		
		
		
		
		httpEntity = new HttpEntity<Object>(body, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> responseMap =  restTemplate.exchange(REST_SERVICE_URI, HttpMethod.POST, httpEntity, Map.class);
		return null;
	}

	@Override
	public String executePayment() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setHeaders(HttpHeaders headers) {

	}

}
