package com.reward.dto;

import java.util.Date;

public class TransactionDto {
	
	private Long transactionId;
	private Long customerId;
	private Date transactionDate;
	private Double transactionAmount;
	private Long rewards;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Long getRewards() {
		return rewards;
	}
	public void setRewards(Long rewards) {
		this.rewards = rewards;
	}
	
}
