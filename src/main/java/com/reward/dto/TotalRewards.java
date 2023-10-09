package com.reward.dto;

import java.util.List;

import com.reward.entity.Transaction;

public class TotalRewards {
	
	private Long customerId;
	private List<Transaction> allTransactions;
	private String totalRewardsPoints;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public List<Transaction> getAllTransactions() {
		return allTransactions;
	}
	public void setAllTransactions(List<Transaction> allTransactions) {
		this.allTransactions = allTransactions;
	}
	public String getTotalRewardsPoints() {
		return totalRewardsPoints;
	}
	public void setTotalRewardsPoints(String totalRewardsPoints) {
		this.totalRewardsPoints = totalRewardsPoints;
	}
	

}
