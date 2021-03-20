package com.springioc02.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springioc02.controller.UserServlet;
/**
 * spring的单元测试
 * @author admin
 *
 */
@ContextConfiguration(locations = "classpath:springioc02.xml")//指定spring的xml生成ioc容器
@RunWith(SpringJUnit4ClassRunner.class)//spring的单元测试
public class Test02 {

	@Autowired
	UserServlet ust;
	
	@Test
	public void test01() {
		System.out.println(ust);
	}
}
