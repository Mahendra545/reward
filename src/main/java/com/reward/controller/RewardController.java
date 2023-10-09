package com.reward.controller;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.reward.dto.TotalRewards;
import com.reward.dto.TransactionDto;
import com.reward.service.RewardService;

@RestController
public class RewardController {
	@Autowired
	private RewardService rewardService;
	
	@PostMapping("/transaction")
	public String transaction(@RequestBody TransactionDto transaction) {
		return rewardService.transaction(transaction);
	}
	@GetMapping("/reward_points/{transactionId}")
	public String getRewardsBytransactionId(@PathVariable long transactionId) {
		return rewardService.getRewardsBytransactionId(transactionId);
	}
	@GetMapping("/total_reward_points/{customerId}")
	public TotalRewards getTotalRewardsPointsByDateRange(@PathVariable long customerId, @RequestHeader(required = false) String startDate,@RequestHeader(required = false) String endDate) throws ParseException {
		return rewardService.getTotalRewardsPointsByDateRange(customerId,startDate,endDate);
	}

}
