package com.primeStore.musicStore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primeStore.musicStore.domain.Customer;
import com.primeStore.musicStore.domain.CustomerOrder;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addCustommerOrder(CustomerOrder customerOrder) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customerOrder);
		session.flush();
		
	}



	

}
