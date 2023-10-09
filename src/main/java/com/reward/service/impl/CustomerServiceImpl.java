package com.reward.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.entity.Customer;
import com.reward.repository.CustomerRepository;
import com.reward.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public String save(Customer customer) {
		Customer customerDetails = customerRepository.save(customer);
		return "Customer id is : "+customerDetails.getCustomerId();
	}

}
