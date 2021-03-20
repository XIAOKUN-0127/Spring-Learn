package com.springioc02.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springioc02.bean.User;
import com.springioc02.dao.UserDAO;

@Service("ub")
public class UserBiz {
	
	@Autowired
	UserDAO userDAO;
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user) {
		System.out.println("登录biz...");
		return userDAO.login(user);
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public Integer register(User user) {
		System.out.println("注册biz...");
		return userDAO.register(user);
	}
}
