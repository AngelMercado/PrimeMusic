package com.primeStore.musicStore.dao;

import java.util.List;

import com.primeStore.musicStore.domain.Customer;

public interface CustomerDao {
	void addCustomer(Customer customer);
	Customer getCustomerById(int customerId);
	List<Customer> getAllCustomers();
	Customer getCustomerByUsername(String username);
}
