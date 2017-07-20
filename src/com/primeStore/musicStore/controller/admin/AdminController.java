package com.primeStore.musicStore.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.primeStore.musicStore.domain.Product;
import com.primeStore.musicStore.service.ProductService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("productInventory")
	public String productInventory(Model model) {
		List<Product> productList = productService.getproductList();
		model.addAttribute("products",productList);
		return "inventory";
	}
	@RequestMapping("/customer")
	public String customerManagement(Model model) {
//		to add some customer services latter
		return "customerManagement";
	}
}
