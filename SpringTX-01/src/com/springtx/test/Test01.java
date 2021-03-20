package com.springtx.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Test01 {
	
	ApplicationContext ioc=new ClassPathXmlApplicationContext("app.xml");
	
	@Test
	public void testTemplate() throws Exception {
		DataSource dataSource=ioc.getBean(DataSource.class);
		System.out.println(dataSource);
		Connection conn=(Connection) dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}
	
}
