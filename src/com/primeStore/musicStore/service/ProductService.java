package com.primeStore.musicStore.service;

import java.util.List;

import com.primeStore.musicStore.domain.Product;

public interface ProductService {

	List<Product> getproductList();
	Product getProductById(int productId);
	void addProduct(Product product);
	void editProduct(Product product);
	void deleteProduct(Product product);
	
}
