package com.reward.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.dto.TotalRewards;
import com.reward.dto.TransactionDto;
import com.reward.entity.Transaction;
import com.reward.repository.RewardRepository;
import com.reward.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService {
	
	private static final Logger logger = LoggerFactory.getLogger(RewardServiceImpl.class);
	@Autowired
	private RewardRepository rewardRepository;

	@Override
	public String transaction(TransactionDto transaction) {
		Transaction transactionDetails = new Transaction();
		long rewards=0;
		if(transaction.getTransactionAmount() !=null && transaction.getTransactionAmount()>50 && transaction.getTransactionAmount()<=100) {
			int rewardsAmount = (int)(transaction.getTransactionAmount()-50);
			rewards = rewardsAmount*1;
		}
		if(transaction.getTransactionAmount() !=null && transaction.getTransactionAmount()>=100) {
			long rewardsAmount = (long)(Math.round(transaction.getTransactionAmount()-100));
			rewards = rewards + (rewardsAmount*2)+50;
		}
		transactionDetails.setRewards(rewards);
		transactionDetails.setCustomerId(transaction.getCustomerId());
		transactionDetails.setTransactionAmount(transaction.getTransactionAmount());
		transactionDetails.setTransactionDate(new Date());
		transactionDetails = rewardRepository.save(transactionDetails);
		return "You got "+transactionDetails.getRewards()+" rewards point for "+transactionDetails.getTransactionId()+" transaction id";
	}

	@Override
	public String getRewardsBytransactionId(long transactionId) {
		logger.info("Getting transaction details by transaction id : {}",transactionId);
		Optional<Transaction> transactionDetailsOptional = rewardRepository.findById(transactionId);
		if(transactionDetailsOptional.isPresent()) {
			Transaction transactionDetails = transactionDetailsOptional.get();
			logger.info("Transaction details are : {}",transactionDetails);
			return "You received "+transactionDetails.getRewards()+" reward points for "+transactionDetails.getTransactionId()+" transaction id and spent $"+transactionDetails.getTransactionAmount();
		} else {
			logger.error("transactionId "+ transactionId +" is not existed");
			return "transactionId "+ transactionId +" is not existed";
		}
	}

	@Override
	public TotalRewards getTotalRewardsPointsByDateRange(long customerId, String startDate, String endDate) throws ParseException {
		logger.info("getTotalRewardsPointsByDateRange():: started");
		TotalRewards totalRewards = new TotalRewards();
		totalRewards.setCustomerId(customerId);
		List<Transaction> allTransactions = null;
		if(startDate !=null && endDate != null && startDate.length()>0 && endDate.length()>0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			logger.info("startDate: {}",startDate);
			logger.info("endDate: {}",endDate);
			allTransactions = rewardRepository.findByCustomerIdAndTransactionDateBetween(customerId, sdf.parse(startDate), sdf.parse(endDate));
		}else {
			Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.DAY_OF_YEAR, -90);
	        Date ninetyDaysAgo = calendar.getTime();
			allTransactions = rewardRepository.findByCustomerIdAndTransactionDateGreaterThanEqual(customerId, ninetyDaysAgo);
		}
		if(!allTransactions.isEmpty()) {
			totalRewards.setAllTransactions(allTransactions);
			long points= 0 ;
			for(Transaction transaction: allTransactions) {
				points = points + transaction.getRewards();
			}
			logger.info("All Transaction count is : {}",allTransactions.size());
			logger.info("Total rewards points is : {}",points);
			totalRewards.setTotalRewardsPoints(points+"");
		}
		return totalRewards;
	}


}
