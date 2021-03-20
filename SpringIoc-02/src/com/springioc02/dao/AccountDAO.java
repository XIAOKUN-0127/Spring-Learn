package com.springioc02.dao;

import org.springframework.stereotype.Repository;

import com.springioc02.bean.User;
@Repository
public class AccountDAO {
	/**
	 * 取钱
	 * @param money
	 * @return
	 */
	public Double getMoney(User user,Double money) {
		System.out.println("取钱dao...");
		return money;
	}
	
	/**
	 * 存钱
	 * @param aid
	 * @param money
	 * @return
	 */
	public Double saveMoney(User user,Double money) {
		System.out.println("存钱dao..");
		return money;
	}
	
	public AccountDAO() {
		System.out.println("AccountDAO对象创建...");
	}
}
