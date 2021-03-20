package com.springioc01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springioc01.bean.Person;

public class Test01 {
	/**
	 * 将springioc.xml通过类路径加载解析成 springIoc容器对象
	 */
	ApplicationContext app=new ClassPathXmlApplicationContext("springioc01.xml");
	
	/**
	 * spring 容器两次获取同一个id的对象,所得到的是同一对象
	 */
	@Test
	public void testPerson01() {
		
		Person person01=(Person) app.getBean("person01");//返回Object对象
		Person person02=(Person) app.getBean("person02");//返回Object对象
		//获取容器不存在的对象,
		//报错：NoSuchBeanDefinitionException: No bean named 'person03' is defined
		//Person person03=(Person) app.getBean("person03");
		//两次获取的同一id的对象是同一个
		//System.out.println(person01==person02);
		//System.out.println("person01:"+person01);
		//System.out.println("person01:"+person02);
		//System.out.println("person01:"+person03);
	}
	
	/**
	 * 按类获得对象时,如果有两个同一类的bean所报错误
	 */
	@Test
	public void testPerson02() {
		//有多个Person对象用类获得实例时报错：NoUniqueBeanDefinitionException: No qualifying bean of type [com.springioc01.bean.Person] is defined: expected single matching bean but found 2: person01,person02
		//Person person01=app.getBean(Person.class);
		//根据id和类获得对象
		Person person01=app.getBean("person01",Person.class);
		System.out.println(person01+"--2");
	}
	
	/**
	 * getBean()方法根据id和类获得对象
	 */
	@Test
	public void testPerson03() {
		Person person01=app.getBean("person01",Person.class);
		Object person03=app.getBean("person03");
		System.out.println(person01);
		System.out.println(person03);
	}
	
	/**
	 * 构造器赋值,index属性指定赋值顺序,从0开始
	 */
	@Test
	public void testPerson04() {
		Object person04=app.getBean("person04");
		System.out.println(person04);
	}
	
	/*
	 * 引入 p名称空间 为bean赋值 底层采用 set方式设值 
	 * 名称空间是为了防止名称重复 book>name和book>author>name不一样
	 */
	@Test
	public void testPerson05() {
		Object person05=app.getBean("person05");
		System.out.println(person05);
	}
	
	/**
	 * 为对象赋值为null
	 */
	@Test
	public void testPerson06() {
		Object person06=app.getBean("person06");
		System.out.println(person06);
	}
}
