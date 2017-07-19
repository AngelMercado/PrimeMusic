package com.primeStore.musicStore.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primeStore.musicStore.dao.ProductDao;
import com.primeStore.musicStore.domain.Product;
import java.io.File;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;


@Controller
public class IndexController {
	
    @Autowired
	ProductDao productDao;

	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping(value="/")
	public String test(Model model) {	
		return "index";
	}
	@RequestMapping(value="/productList")
	public String getProductList(Model model){
		List<Product> productList=productDao.getProductList();
		Product product = productList.get(0);
		model.addAttribute("products",productList);
		return "productList";
	}
	@RequestMapping(value="/productList/productDetail/{productId}")
	public String getProductDetail(@PathVariable String productId ,Model model){
		Product product;
		product = productDao.getProductByID(productId);
		model.addAttribute("product",product);
		
		return "productDetail";
	}
	
	
}