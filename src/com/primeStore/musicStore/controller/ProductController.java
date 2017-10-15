package com.primeStore.musicStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primeStore.musicStore.domain.Product;
import com.primeStore.musicStore.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/productList")
	public String productList(Model model) {
		List<Product> products= productService.getproductList();
		model.addAttribute("products",products);
		return "productList";
	}
	@RequestMapping(value="/productDetail/{idProduct}")
	public String productView(@PathVariable("idProduct") int idProduct, Model model) {
		Product product = productService.getProductById(idProduct);
		model.addAttribute("product",product);
		return "productDetail"; 
	}
	
}
