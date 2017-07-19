package com.primeStore.musicStore.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.primeStore.musicStore.dao.ProductDao;
import com.primeStore.musicStore.domain.Product;

@Controller
public class adminController {
	private Path path;
	@Autowired
	ProductDao productDao;
	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping(value="/admin")
	public String adminPage(){
		return "admin";
	}
	@RequestMapping(value="/test")
	public String test(){
		return "test";
	}
	@RequestMapping(value="/admin/productInventory")
	public String productInventoryPage(Model model){
		List<Product> productList=productDao.getProductList();
		model.addAttribute("products",productList);
		return "inventory";
	}
	@RequestMapping(value="/admin/productInventory/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		product.setProductCategory("Instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		model.addAttribute("product",product);
		return "addProd";
	}
	@RequestMapping(value="/admin/productInventory/addProduct" ,method=RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product")Product product,BindingResult result,HttpServletRequest request){
		if(result.hasErrors()) {
			return "addProd";
		}
		
		logger.info("save product data");
		productDao.addProduct(product);
                MultipartFile productImage= product.getProductImage();
                String rootDirectory = request.getSession().getServletContext().getRealPath("/");
                path = Paths.get(rootDirectory+ "resources/images/" +product.getIdProduct()+".png");
		if(productImage!= null && !productImage.isEmpty()){		
                    try {
                    	logger.info("trying to storage image product");                    	
                        productImage.transferTo(new File(path.toString()));
                        logger.info("Product Image saving Success");
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(e);
                        throw new RuntimeException("##############Product Image saving failed"+e);
                    }
                }
                return "redirect:/admin/productInventory";
	}
	@RequestMapping(value="/admin/productInventory/editProduct/{id}")
	public String editProduct(@PathVariable("id")String id,Model model){
		Product product = productDao.getProductByID(id);
		model.addAttribute(product);			
		return "editProduct";
	}
	@RequestMapping(value="/admin/productInventory/editProduct" ,method=RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") Product product, HttpServletRequest request) {
		MultipartFile productImage= product.getProductImage();
		String rootDirectory= request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"resources/images/"+product.getIdProduct()+".png");
		
		if(productImage !=null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed "+e);
			}
		}
		productDao.editProduct(product);
		return "redirect:/admin/productInventory/";
	}
	@RequestMapping(value="/admin/productInventory/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable String productId,HttpServletRequest request){		
		String rootDirectory= request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+ "resources/images/" +productId+".png");
		if(Files.exists(path)){
			try {
				Files.delete(path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		productDao.deleteProduct(productId);
		return "redirect:/admin/productInventory";
	}
}
