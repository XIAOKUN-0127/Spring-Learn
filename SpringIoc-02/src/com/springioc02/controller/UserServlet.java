package com.springioc02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springioc02.bean.User;
import com.springioc02.biz.UserBiz;

@Controller("uc")
@Scope(value = "prototype")
public class UserServlet {

	@Autowired(required = false)//默认为true,必须装配
	@Qualifier("ubm")//指定自动装配的新id
	UserBiz userBiz;
	/**
	 * 登录
	 * @param user
	 */
	public void login(User user) {
		System.out.println("login..servlet...");
		userBiz.login(user);
	}
	
	/**
	 * 注册
	 * @param user
	 */
	public void register(User user) {
		System.out.println("register..servlet..."+userBiz);
		//userBiz.register(user);
	}
}
