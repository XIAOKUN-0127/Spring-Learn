package com.springioc02.dao;

import org.springframework.stereotype.Repository;

import com.springioc02.bean.User;
@Repository("udao")
public class UserDAO {
	/*
	 * 登录
	 */
	public User login(User user) {
		System.out.println("登录dao...");
		return user;
	}
	
	/*
	 * 注册
	 */
	public Integer register(User user) {
		System.out.println("注册dao...");
		return 1;
	}
}
