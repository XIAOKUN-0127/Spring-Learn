package com.springioc01.factory;

import org.springframework.beans.factory.FactoryBean;

import com.springioc01.bean.Person;

public class FactoryBeanImpl implements FactoryBean<Person>{

	@Override
	public Person getObject() throws Exception {
		// TODO Auto-generated method stub
		Person person=new Person(null,"mmmmmmmmm",0);
		System.out.println("factoryBean>..");
		return person;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Person.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
