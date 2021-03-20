package com.springioc01.factory;

import com.springioc01.bean.Person;
/**
 * 静态工厂
 * @author admin
 *
 */
public class PersonStaticFactory {

	public static Person getPerson(int age) {
		System.out.println("静态。。工厂");
		return new Person(null,null,age);
	}
}
