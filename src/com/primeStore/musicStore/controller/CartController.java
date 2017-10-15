package com.primeStore.musicStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primeStore.musicStore.domain.Customer;
import com.primeStore.musicStore.service.CustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

	@Autowired
	CustomerService customerService;

	@RequestMapping
	public String getCart(@AuthenticationPrincipal User activeUser) {
		Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());
		int cartId = customer.getCart().getIdCart();
		return "redirect:/customer/cart/" + cartId;
	}

	@RequestMapping("/{cartId}")
	public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model) {
		model.addAttribute("cartId", cartId);
		return "cart";
	}

}
