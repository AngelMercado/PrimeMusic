package com.primeStore.musicStore.dao;

import java.io.IOException;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;
import com.primeStore.musicStore.service.CustomerOrderService;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	CustomerOrderService customerOrderService;
	@Override
	public Cart getCartById(int idCart) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = (Cart) session.get(Cart.class, idCart);
		return cart;
	}

	@Override
	public void update(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		int cartId = cart.getIdCart();
		double grandTotal = customerOrderService.getCustommerOrderGrandTotal(cartId);
		cart.setGrandTotal(grandTotal);
		
		session.saveOrUpdate(cart);
		
		
	}


	@Override
	public Cart validate(int cartId) throws IOException{
		Cart cart = getCartById(cartId);
		if (cart==null || cart.getCartItems().size()==0) {
			throw new IOException(cartId+"");
			
		}
		update(cart);
		
		return cart;
	}
	
	
	
}
