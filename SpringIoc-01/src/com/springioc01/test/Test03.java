package com.springioc01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
	/**
	 * 将springioc.xml通过类路径加载解析成 springIoc容器对象
	 */
	ApplicationContext app=new ClassPathXmlApplicationContext("springioc01.xml");
	
	/**
	 * 实例工厂 创建
	 */
	@Test
	public void test01(){
		Object p1=app.getBean("p1");
		System.out.println(p1);
		
	}
	
	/**
	 * 静态工厂 创建
	 */
	@Test
	public void test02(){
		Object p2=app.getBean("p2");
		System.out.println(p2);
		
	}
	
	/**
	 * FactoryBean接口 创建,
	 * scope="singonle/property"都是获得时创建该bean对象
	 */
	@Test
	public void test03(){
		Object impl=app.getBean("impl");
		System.out.println(impl);
		
	}
	
	/**
	 * parent 继承配置
	 * abstract="true"的bean仅可作为模板 继承  不可实例化 (BeanAbtractException)
	 */
	@Test
	public void test04(){
		Object p3=app.getBean("p3");
		System.out.println("parent:"+p3);
		Object p4=app.getBean("p4");
		System.out.println("child:"+p4);
		
	}
}
