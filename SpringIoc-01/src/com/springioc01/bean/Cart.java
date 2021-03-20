package com.springioc01.bean;

public class Cart {

	String cname;
	String cprice;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCprice() {
		return cprice;
	}
	public void setCprice(String cprice) {
		this.cprice = cprice;
	}
	@Override
	public String toString() {
		return "Cart [cname=" + cname + ", cprice=" + cprice + "]";
	}
	
}
