package com.primeStore.musicStore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.credential.TokenAuthorization;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;
import com.primeStore.musicStore.domain.Customer;
import com.primeStore.musicStore.domain.CustomerOrder;
import com.primeStore.musicStore.restClient.PayPalClientImpl;
import com.primeStore.musicStore.service.CartService;
import com.primeStore.musicStore.service.CustomerOrderService;
import com.primeStore.musicStore.service.CustomerService;

@Controller
@RequestMapping("/payment")
public class PaymentResources {

	private APIContext apiContext = new APIContext(
			"******",
			"******", "live");
	@Autowired
	CartService cartService;
	
	@Autowired
	CustomerOrderService customerOrderService;
	 
	@Autowired
	CustomerService customerService;

	final static Logger logger = Logger.getLogger(PaymentResources.class);
	
	@RequestMapping(value = "/create-payment", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> createPayment(@RequestParam(value="idCart") int param) {
		
		Map<String, String> res = new HashMap<String, String>();
		int idCart = param;
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		// Set redirects URLs
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setReturnUrl("http://localhost:3000/process");
		redirectUrls.setCancelUrl("http://localhost:3000/cancel");

				

		// Add items from cart
		Cart cart = cartService.getCartById(idCart);
		List<CartItem> cartItems = cart.getCartItems();
		ItemList itemList = new ItemList();
		List<Item> itemListContent = new ArrayList<Item>();
			
		int iterador= 0;
		double grandTotal=0.0;
		for (CartItem cartItem : cartItems) {
			Item item = new Item();	
			item.setName(cartItem.getProduct().getProductName());
			item.setDescription(cartItem.getProduct().getProductDescription());
			item.setQuantity(Integer.toString(cartItem.getQuatity()));
			item.setPrice(Double.toString(cartItem.getProduct().getProductPrice()));
			item.setCurrency("USD");
			itemListContent.add(iterador, item);
			iterador+=1;
			grandTotal+=cartItem.getTotalPrice();
		}
		
		// Set payment amount
		String GrandtotalPrice = Double.toString(grandTotal);
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal(GrandtotalPrice);
		itemList.setItems(itemListContent);
		
		// Set payment Details
		Details details = new Details();
		
		// Set Transaction information
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("Lista de Articulos comprados en PrimeStore, gracias por tu preferencia");
		transaction.setItemList(itemList);
		
		// Set transaction List	
		List<Transaction> transactionList = new ArrayList<>();
		transactionList.add(transaction);
		
		// Set Payment
		Payment payment = new Payment();
		Payment definedPayment = new Payment();
		payment.setIntent("sale");
		payment.setRedirectUrls(redirectUrls);
		payment.setPayer(payer);
		payment.setTransactions(transactionList);
		
		try {
			definedPayment = payment.create(apiContext);
			logger.info("================================>defined Payment: " + definedPayment.toJSON());
			res.put("id", definedPayment.getId().toString());
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "/proccess",method=RequestMethod.GET)
	public String executePayment(@RequestParam(value="paymentId") String paymentId,@RequestParam(value="token") String token, @RequestParam(value="PayerID") String payerId) {
		Payment payment = new Payment();
		payment.setId(paymentId);

		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);

		Payment createdPayment;

		try {
			createdPayment = payment.execute(apiContext, paymentExecution);
			if(createdPayment.getState().equals("approved")) {
				return "successPayment";
			}else {
				return "failPayment";
			}

		} catch (PayPalRESTException e) {
			createdPayment = null;
			System.out.println(e.getDetails());
		}

		return "invalidPayment";
	}
	@RequestMapping(value="/cancelled",method=RequestMethod.GET)
	public String cancellPayment(@AuthenticationPrincipal User activeUser) {
		Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());
		int cartId = customer.getCart().getIdCart();
		return "redirect:/customer/cart/" + cartId;
	}

}
