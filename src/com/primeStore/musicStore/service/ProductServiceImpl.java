package com.primeStore.musicStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.primeStore.musicStore.dao.ProductDao;
import com.primeStore.musicStore.domain.Product;

public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;
	

	@Override
	public Product getProductById(int idProduct) {
		
		return productDao.getProductByID(idProduct);
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
		
	}

	@Override
	public void editProduct(Product product) {
		productDao.editProduct(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product.getIdProduct());
		
	}

	@Override
	public List<Product> getproductList() {
		
		return productDao.getProductList();
	}

}
