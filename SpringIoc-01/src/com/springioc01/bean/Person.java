package com.springioc01.bean;

public class Person {
	private String name;
	private String sex;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		//System.out.println("设定name:"+name);
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
	public Person() {
		//System.out.println("Person对象创建...");
	}
	public Person(String name, String sex, int age) {	
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		System.out.println("有参构造器...");
	}
	
	
}
