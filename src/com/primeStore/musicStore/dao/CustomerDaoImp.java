package com.primeStore.musicStore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primeStore.musicStore.domain.Authorities;
import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.Customer;
import com.primeStore.musicStore.domain.User;
@Repository
@Transactional
public class CustomerDaoImp implements CustomerDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addCustomer(Customer customer) {
		Session session= sessionFactory.getCurrentSession();
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);		
		
//		session.saveOrUpdate(customer);
//		session.saveOrUpdate(customer.getBillingAddress());
//		session.saveOrUpdate(customer.getShippingAddress());
		
		User newUser = new User();
		newUser.setUsername(customer.getUsername());
		newUser.setPassword(customer.getPassword());
		newUser.setEnabled(true);
		newUser.setCustomerId(customer.getIdCustomer());
		Authorities newAuthority= new Authorities();
		newAuthority.setAuthority("ROLE_USER");
		newAuthority.setUsername(customer.getUsername());
		
		Cart newCart = new Cart();
		newCart.setCustomer(customer);
		customer.setCart(newCart);
		
		
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		session.saveOrUpdate(newUser);
		session.saveOrUpdate(newAuthority);
		session.saveOrUpdate(newCart);
		session.flush();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Session session= sessionFactory.getCurrentSession();
		Customer customer;
		customer = (Customer) session.get(Customer.class,customerId);		
		session.flush();
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customerList = query.list();
		return customerList;
	}

}
