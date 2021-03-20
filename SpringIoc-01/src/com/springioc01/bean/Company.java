package com.springioc01.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Company {

	String name;
	List<Cart>carts;
	Map<String,Object>maps;
	Properties properties;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", carts=" + carts + ", maps=" + maps + ", properties=" + properties + "]";
	}
	
	
	
}
