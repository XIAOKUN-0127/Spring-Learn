package com.springioc02.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springioc02.bean.User;
import com.springioc02.dao.AccountDAO;

@Service
public class AccountBiz {
	
	@Autowired
	AccountDAO accountDAO;
	/**
	 * 取钱
	 * @param user
	 * @param money
	 * @return
	 */
	public Double getMoney(User user,Double money) {
		System.out.println("取钱biz...");
		return accountDAO.getMoney(user, money);
	}
	
	/**
	 * 存钱
	 * @param user
	 * @param money
	 * @return
	 */
	public Double saveMoney(User user,Double money) {
		System.out.println("存钱biz...");
		return accountDAO.saveMoney(user, money);
	}
	
	public AccountBiz() {
		System.out.println("AccountBiz对象创建...");
	}
}
