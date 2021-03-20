package com.springioc02.bean;
/**
 * 账户
 * @author admin
 *
 */
public class Account {
	String aid;
	String apwd;
	Double balance;//账户余额
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", apwd=" + apwd + ", balance=" + balance + "]";
	}
	
}
