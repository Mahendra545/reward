package com.reward.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reward.entity.Customer;
import com.reward.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@PostMapping("/registration")
	public String registration(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

}
