package com.greatlearning.customerRelationshipManagement.service;

import java.util.List;

import com.greatlearning.customerRelationshipManagement.entity.Customer;


public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theCustomer);

	public void deleteById(int theId);
	
}
