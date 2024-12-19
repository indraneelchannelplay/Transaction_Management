package com.transanction.management.model;

import org.springframework.stereotype.Component;

@Component
public class TransactionModel {
	
	long sender;
	long receiver;
	double amount;
	
	public long getSender() {
		return sender;
	}
	public void setSender(long sender) {
		this.sender = sender;
	}
	public long getReceiver() {
		return receiver;
	}
	public void setReceiver(long receiver) {
		this.receiver = receiver;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "TransactionModel [sender=" + sender + ", receiver=" + receiver + ", amount=" + amount + "]";
	}
	
	

}
