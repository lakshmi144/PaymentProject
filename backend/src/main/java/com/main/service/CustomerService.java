package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.beans.Customer;
import com.main.repo.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	@Override
	public Customer findById(String customerid) {
		// TODO Auto-generated method stub
		return customerRepo.findById(customerid).get();
	}
	
	public List<Customer> getbankcustomer(String custid)
	{
		return customerRepo.getbankdetails(custid);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Optional<Customer> optCustomer = customerRepo.findById(customer.getCustomerid());
		if (optCustomer.isPresent()) {
			return customerRepo.save(customer);
		}
		else
			return null;
	}

	@Override
	public Customer deleteCustomer(String customerid) {
		// TODO Auto-generated method stub
		//return null;
		Optional<Customer> optCustomer = customerRepo.findById(customerid);
		if (optCustomer.isPresent()) {
			customerRepo.deleteById(customerid);
			return customerRepo.getById(customerid);
		}
		else
			return null;
		 
	}

	
}
