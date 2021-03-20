package com.springioc02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springioc02.bean.User;
import com.springioc02.biz.AccountBiz;
@Controller
public class AccountServlet {
	@Autowired
	AccountBiz accountBiz;
	
	public void saveMoney(User user,Double money) {
		accountBiz.saveMoney(user, money);
		System.out.println("saveMoney..servlet...");
	}
	
	public void getMoney(User user,Double money) {
		accountBiz.getMoney(user, money);
		System.out.println("getMoney..servlet...");
	}
}
