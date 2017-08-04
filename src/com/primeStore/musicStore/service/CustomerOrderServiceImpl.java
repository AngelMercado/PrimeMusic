package com.primeStore.musicStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeStore.musicStore.dao.CustomerOrderDao;
import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;
import com.primeStore.musicStore.domain.CustomerOrder;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	CustomerOrderDao customerOrderDao;

	@Autowired
	CartService cartService;

	@Override
	public void addCustommerOrder(CustomerOrder customerOrder) {
		customerOrderDao.addCustommerOrder(customerOrder);

	}

	@Override
	public double getCustommerOrderGrandTotal(int idCart) {
		double grandTotal = 0;
		Cart cart = cartService.getCartById(idCart);
		List<CartItem> cartList = cart.getCartItems();
		for (CartItem cartItem : cartList) {
			grandTotal += cartItem.getTotalPrice();
		}
		return grandTotal;
	}

}
