package com.springaop02.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springaop02.impl.MyMathCalucater;
import com.springaop02.inter.Calucater;
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
		System.out.println(calucater);
		System.out.println(calucater.getClass());
	}
}
