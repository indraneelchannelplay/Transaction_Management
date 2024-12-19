package com.transanction.management.model;

public class BalanceModel {
	
	long userId;
	double amount;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "BalanceModel [userId=" + userId + ", amount=" + amount + "]";
	}
	
	

}
