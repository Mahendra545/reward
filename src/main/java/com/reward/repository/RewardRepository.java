package com.reward.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.entity.Transaction;

public interface RewardRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByCustomerIdAndTransactionDateGreaterThanEqual(long customerId, Date date);
	List<Transaction> findByCustomerIdAndTransactionDateBetween(long customerId, Date startDate, Date endDate);
}
