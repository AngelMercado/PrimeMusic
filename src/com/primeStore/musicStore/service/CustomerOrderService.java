package com.primeStore.musicStore.service;

import com.primeStore.musicStore.domain.CustomerOrder;

public interface CustomerOrderService {
	void addCustommerOrder(CustomerOrder customerOrder);
	double getCustommerOrderGrandTotal(int idCart);
}
