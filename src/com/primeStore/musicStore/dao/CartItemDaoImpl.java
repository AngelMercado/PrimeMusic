package com.primeStore.musicStore.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
		
	}

	@Override
	public void removeAllItems(Cart cart) {
		List<CartItem> cartItemList= cart.getCartItems();
		for (CartItem cartItem : cartItemList) {
			removeCartItem(cartItem);
		}
	
		
		
	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where productId= ?");
		query.setInteger(0, productId);
		session.flush();
		
		return (CartItem) query.uniqueResult();  
		
	}
	
}