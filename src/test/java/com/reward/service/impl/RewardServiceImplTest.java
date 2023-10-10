package com.reward.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.reward.dto.TransactionDto;
import com.reward.entity.Transaction;
import com.reward.repository.RewardRepository;

@ExtendWith(SpringExtension.class)
public class RewardServiceImplTest {

	@InjectMocks
	private RewardServiceImpl rewardServiceImpl;
	@Mock
	private RewardRepository rewardRepository;
	@Test
	public void transactionTest() {
		when(rewardRepository.save(Mockito.any())).thenReturn(getTransaction());
		assertNotNull(rewardServiceImpl.transaction(getTransactionDto()));
	}
	@Test
	public void transactionTest1() {
		when(rewardRepository.save(Mockito.any())).thenReturn(getTransaction());
		TransactionDto transaction = getTransactionDto();
		transaction.setRewards(50l);
		transaction.setTransactionAmount(100.00);
		assertNotNull(rewardServiceImpl.transaction(transaction));
	}
	@Test
	public void getRewardsBytransactionIdTest() {
		when(rewardRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(getTransaction()));
		assertNotNull(rewardServiceImpl.getRewardsBytransactionId(1l));
	}
	@Test
	public void getTotalRewardsPointsByDateRangeTest() throws ParseException {
		List<Transaction> allTransactions = new ArrayList<Transaction>();
		allTransactions.add(getTransaction());
		when(rewardRepository.findByCustomerIdAndTransactionDateBetween(Mockito.anyLong(),Mockito.any(),Mockito.any())).thenReturn(allTransactions);
		assertNotNull(rewardServiceImpl.getTotalRewardsPointsByDateRange(1l,"2023-10-08","2023-10-08"));
	}
	@Test
	public void getTotalRewardsPointsByDateRangeTest1() throws ParseException {
		List<Transaction> allTransactions = new ArrayList<Transaction>();
		allTransactions.add(getTransaction());
		when(rewardRepository.findByCustomerIdAndTransactionDateGreaterThanEqual(Mockito.anyLong(),Mockito.any())).thenReturn(allTransactions);
		assertNotNull(rewardServiceImpl.getTotalRewardsPointsByDateRange(1l,"",""));
	}
	private Transaction getTransaction() {
		Transaction transaction = new Transaction();
		transaction.setCustomerId(1l);
		transaction.setRewards(90l);
		transaction.setTransactionAmount(120.00);
		transaction.setTransactionDate(new Date());
		transaction.setTransactionId(1l);
		return transaction;
	}
	private TransactionDto getTransactionDto() {
		TransactionDto transaction = new TransactionDto();
		transaction.setCustomerId(1l);
		transaction.setRewards(90l);
		transaction.setTransactionAmount(120.00);
		transaction.setTransactionDate(new Date());
		transaction.setTransactionId(1l);
		return transaction;
	}
}
