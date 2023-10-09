package com.reward.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
