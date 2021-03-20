package com.springioc01.bean;

public class User {
	String id;
	String uname;
	Adress address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Adress getAddress() {
		return address;
	}
	public void setAddress(Adress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", address=" + address + "]";
	}
	

}
