package com.springtx03.bean;

public class Account {
	private String aname;
	private double balance;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [aname=" + aname + ", balance=" + balance + "]";
	}
	
	
	
}
