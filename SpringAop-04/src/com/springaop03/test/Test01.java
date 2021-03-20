package com.springaop03.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springaop03.impl.MyMathCalucater;
import com.springaop03.inter.Calucater;
/**
 * 
 * @author admin
 *
 */
public class Test01 {
	@Test
	public void test01() {
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		Calucater calucater=app.getBean(Calucater.class);
		calucater.add(1, 2);
		calucater.sub(1, 2);
		calucater.div(1, 0);
		System.out.println(calucater);
		System.out.println(calucater.getClass());
	}
}
