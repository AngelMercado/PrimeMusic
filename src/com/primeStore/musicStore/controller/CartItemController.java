package com.primeStore.musicStore.controller;

import java.lang.reflect.Method;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/cart")
public class CartItemController {

	@RequestMapping
	public String get (HttpServletRequest request) {		
		//cart is related to one session
		return "redirect:/cart/"+request.getSession().getId();
	}
	@RequestMapping(value="/{cartId}",method=RequestMethod.GET)
	public String getCart(@PathVariable(value="cartId")String cartId,Model model) {
		model.addAttribute("cartId",cartId);
		return "cart";
	}
}
