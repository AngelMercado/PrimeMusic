package com.primeStore.musicStore.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomMapEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.Customer;
import com.primeStore.musicStore.domain.CustomerOrder;
import com.primeStore.musicStore.restClient.PayPalClientImpl;
import com.primeStore.musicStore.service.CartService;

import com.primeStore.musicStore.service.CustomerOrderService;

@Controller
public class OrderController {

	@Autowired
	private CartService cartService;
	
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	final static Logger logger = Logger.getLogger(OrderController.class);
	
	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId) {
		CustomerOrder customerOrder= new CustomerOrder();
		Cart cart = cartService.getCartById(cartId);
		Customer customer = cart.getCustomer();
		customerOrder.setCart(cart);
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShippingAddress(customer.getShippingAddress());
		
		customerOrderService.addCustommerOrder(customerOrder);
		
		return "redirect://checkout?cartId="+cartId;
	}
}
