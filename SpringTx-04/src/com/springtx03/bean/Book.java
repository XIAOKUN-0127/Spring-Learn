package com.springtx03.bean;

public class Book {
	private String isbn;
	private String bname;
	private double bprice;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public double getBprice() {
		return bprice;
	}
	public void setBprice(double bprice) {
		this.bprice = bprice;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bname=" + bname + ", bprice=" + bprice + "]";
	}
	
	
}
