package com.reward.service;

import java.text.ParseException;
import java.util.Date;

import com.reward.dto.TotalRewards;
import com.reward.dto.TransactionDto;

public interface RewardService {

	String transaction(TransactionDto transaction);

	String getRewardsBytransactionId(long transactionId);

	TotalRewards getTotalRewardsPointsByDateRange(long customerId,String startDate, String endDate) throws ParseException;

}
