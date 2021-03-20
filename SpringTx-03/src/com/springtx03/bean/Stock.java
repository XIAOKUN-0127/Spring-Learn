package com.springtx03.bean;

public class Stock {

	private int stockid;
	private String isbn;
	private double stock;
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Stock [stockid=" + stockid + ", isbn=" + isbn + ", stock=" + stock + "]";
	}
	
	
}
