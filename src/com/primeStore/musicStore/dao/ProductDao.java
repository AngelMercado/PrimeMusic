package com.primeStore.musicStore.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.primeStore.musicStore.domain.Product;

public interface ProductDao {
	void addProduct(Product product);
	Product getProductByID(int id);
	List<Product> getProductList();	
	void deleteProduct(int id);
	void editProduct(Product product);
}
