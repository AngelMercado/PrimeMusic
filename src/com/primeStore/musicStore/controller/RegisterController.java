package com.primeStore.musicStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.primeStore.musicStore.domain.BillingAddress;
import com.primeStore.musicStore.domain.Customer;
import com.primeStore.musicStore.domain.ShippingAddress;
import com.primeStore.musicStore.service.CustomerService;

@Controller
public class RegisterController {
	@Autowired
	CustomerService customerService;
	@RequestMapping("/register")
	public String registerCustomer(Model model) {
		Customer customer = new Customer();		
		model.addAttribute("customer",customer);
		
		return "registerCustomer";	
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerCustomerPost(@ModelAttribute("customer")Customer customer,Model model) {
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		customer.setEnabled(true);
		customer.setEnabled(true);
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		customerService.addCustomer(customer);
		model.addAttribute("obj",customer.getCustomerName());
		return "registerCustomerSuccess";
	}
	
}
