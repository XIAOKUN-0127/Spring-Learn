package com.springioc01.bean;

public class Adress {
	String shen;
	String shi;
	String xian;
	public String getShen() {
		return shen;
	}
	public void setShen(String shen) {
		this.shen = shen;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public String getXian() {
		return xian;
	}
	public void setXian(String xian) {
		this.xian = xian;
	}
	@Override
	public String toString() {
		return "Adress [shen=" + shen + ", shi=" + shi + ", xian=" + xian + "]";
	}
	
}
