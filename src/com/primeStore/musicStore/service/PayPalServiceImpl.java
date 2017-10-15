package com.primeStore.musicStore.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;
@Service("payPalService")
public class PayPalServiceImpl implements PayPalService{

	private APIContext apiContext = new APIContext(
			"******",
			"******", "live");
	@Autowired
	CartService cartService;
	
	@Autowired
	CustomerOrderService customerOrderService;
	
	@Override
	public String createPayment(Cart cartP) throws IOException {
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");
		int idCart = cartP.getIdCart();
		// Set redirects URLs
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setReturnUrl("http://localhost:8080/primeMusic/payment/proccess");
		redirectUrls.setCancelUrl("http://localhost:8080/primeMusic/payment/cancelled");

				

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
			item.setCurrency("MXN");
			itemListContent.add(iterador, item);
			iterador+=1;
			grandTotal+=cartItem.getTotalPrice();
		}
		
		// Set payment amount
		String GrandtotalPrice = Double.toString(grandTotal);
		Amount amount = new Amount();
		amount.setCurrency("MXN");
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
			Iterator<Links> links = definedPayment.getLinks().iterator();
			  while (links.hasNext()) {
			    Links link = links.next();
			    if (link.getRel().equalsIgnoreCase("approval_url")) {
			      return link.getHref();
			    }
			  }
		} catch (PayPalRESTException e) {
			definedPayment=null;
			e.printStackTrace();
		}
		if (definedPayment==null) {
			throw new IOException("");
		}
		return "";

		
	}

}
