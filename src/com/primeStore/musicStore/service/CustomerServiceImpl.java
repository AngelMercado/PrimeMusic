package com.primeStore.musicStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeStore.musicStore.dao.CustomerDao;
import com.primeStore.musicStore.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
		
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerDao.getCustomerById(customerId);
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		 return customerDao.getAllCustomers();
		
	}

}
