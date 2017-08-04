package com.primeStore.musicStore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		BillingAddress billingAddress = customer.getBillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		customer.setEnabled(true);
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		model.addAttribute("customer",customer);
		
		return "registerCustomer";	
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerCustomerPost(@Valid @ModelAttribute("customer")Customer customer,BindingResult result ,Model model) {		
		if (result.hasErrors()) {
			return "registerCustomer";
		}
		List<Customer> customerList= customerService.getAllCustomers();
		
		for (int i = 0; i < customerList.size(); i++) {
			if (customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())) {
				model.addAttribute("emailMsg", "Email already exists");
				return "registerCustomer";
			}
			if (customer.getUsername().equals(customerList.get(i).getUsername())) {
				model.addAttribute("usernameMsg","userName already exists");
				return "registerCustomer";
			}
		}
		customerService.addCustomer(customer);		
		return "registerCustomerSuccess";
	}
	
}
