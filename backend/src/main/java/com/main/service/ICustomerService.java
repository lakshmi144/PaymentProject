package com.main.service;

import java.util.List;

import com.main.beans.Customer;

public interface ICustomerService {
	Customer addCustomer(Customer customer);

	Customer findById(String customerid);

	List<Customer> findAll();

	Customer updateCustomer(Customer customer);
	
	Customer deleteCustomer(String customerid);


}
