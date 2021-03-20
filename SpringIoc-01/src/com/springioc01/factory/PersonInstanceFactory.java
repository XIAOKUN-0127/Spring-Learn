package com.springioc01.factory;

import com.springioc01.bean.Person;
/**
 * 实例工厂
 * @author admin
 *
 */
public class PersonInstanceFactory {

	public Person getPersonInstance(String name) {
		System.out.println("实例工厂。。。");
		return new Person(name,null,0);
	}
}
