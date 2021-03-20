package com.springioc01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springioc01.bean.Company;

public class Test02 {
	/**
	 * 将springioc.xml通过类路径加载解析成 springIoc容器对象
	 */
	ApplicationContext app=new ClassPathXmlApplicationContext("springioc01.xml");
	
	/**
	 * 测试<null>赋空值。
	 *   1.直接不写null值的属性<property> 
	 *   2.<property name=""><null>
	 *   3.xml的value=""都是文本,赋值时需要类型转换
	 */
	@Test
	public void test01() {
		Object user01=app.getBean("user01");
		System.out.println("user01:"+user01);
	}
	
	/**
	 * ref引用赋值 1.外部bean的引用 2.<property><bean内部写bean
	 */
	@Test
	public void test02() {
		Object user02=app.getBean("user02");
		System.out.println("user02:"+user02);
		Object user03=app.getBean("user03");
		System.out.println("user03:"+user03);
		//内部bean不能被获取 ,只能内部使用
		//Object adress02=app.getBean("adress02");
		//System.out.println("adress02:"+adress02);
	}
	
	/**
	 * list的使用 1.ref bean=""> 2.<bean>
	 */
	@Test
	public void test03() {
		Object company01=app.getBean("company01");
		System.out.println("company01:"+company01);
	}
	
	/**
	 * map的使用
	 * <map> <entry key="" value=""/value-ref=""
	 * map的entry嵌套map/list
	 */
	@Test
	public void test04() {
		Object company02=app.getBean("company02");
		System.out.println("company02:"+company02);
	}
	
	/**
	 * Properties的使用  k=v都是字符串类型 值写<prop></prop>标签体内
	 */
	@Test
	public void test05() {
		Company company03=(Company) app.getBean("company03");
		System.out.println("company03-properties:"+company03.getProperties());
	}
	
	@Test
	public void test06() {
		Company company04=(Company) app.getBean("company04");
		System.out.println("company04:"+company04);
	}
	
	/**
	 * 为级联属性赋值  引用 改变当前的属性值后 被引用对象也会改变
	 */
	@Test
	public void test07() {
		Object adress=app.getBean("adress01");
		System.out.println("容器的adress:"+adress);
		Object user04=app.getBean("user04");
		System.out.println("引用的adress改变后:"+user04);
	}
}
