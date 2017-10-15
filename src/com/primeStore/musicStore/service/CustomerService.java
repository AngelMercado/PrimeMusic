package com.primeStore.musicStore.service;

import java.util.List;

import com.primeStore.musicStore.domain.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
	Customer getCustomerById(int customerId);
	List<Customer> getAllCustomers();
	Customer getCustomerByUserName(String username);
	
	
	
}
