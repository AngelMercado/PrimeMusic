package com.primeStore.musicStore.controller.admin;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.primeStore.musicStore.domain.Product;
import com.primeStore.musicStore.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {
	@Autowired
	private ProductService productService;
	private Path path;
	
	@RequestMapping("/product/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setProductCategory("Instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		
		model.addAttribute("product",product);
		return "addProduct";
	}
	
	@RequestMapping(value="/product/addProduct",method=RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product,BindingResult result,HttpServletRequest request, Model model) {
		
		if(result.hasErrors()) {
			return "addProduct";
		}
		productService.addProduct(product);
		MultipartFile productImage = product.getProductImage();
		String rootDirectory= request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"/WEB-INF/resources/images/"+product.getIdProduct()+".png");
		
		if (productImage!=null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product Image saving fail ",e);
			}
		}
		return "redirect:/admin/productInventory";
	}
}
