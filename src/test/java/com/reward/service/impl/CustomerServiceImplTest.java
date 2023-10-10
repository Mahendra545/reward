package com.reward.service.impl;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.reward.entity.Customer;
import com.reward.repository.CustomerRepository;

@ExtendWith(SpringExtension.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	@Mock
	private CustomerRepository customerRepository;
	
	@Test
	public void saveTest() {
		when(customerRepository.save(Mockito.any())).thenReturn(getCustomerDetails());
		assertNotNull(customerServiceImpl.save(getCustomerDetails()));
	}
	
	private Customer getCustomerDetails() {
		Customer customerDetails = new Customer();
		customerDetails.setCustomerId(1l);
		customerDetails.setEmailId("email@gmail.com");
		customerDetails.setMobileNumber("5641233");
		customerDetails.setUserName("tester");
		return customerDetails;
	}
}
