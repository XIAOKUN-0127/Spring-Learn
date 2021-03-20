package com.springtx03.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springtx03.biz.BookBiz;
import com.springtx03.biz.MulTxBiz;
@ContextConfiguration("classpath:tx03.xml")
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TxTest01 {
	//ApplicationContext ioc=new ClassPathXmlApplicationContext("tx03.xml");
	@Autowired
	MulTxBiz txbiz;
	BookBiz biz;
	@Test
	public void test01()   {
		
		//BookBiz biz=ioc.getBean(BookBiz.class);
		String aname="lisi";
		String isbn="ISBN-01";
		int result=biz.checkout(aname, isbn);
		System.out.println("结账结果:"+result);
	}
	
	@Test
	public void testMulTx()  {
		String aname="lisi";
		String isbn="ISBN-01";
		double bprice=999.9;
		txbiz.mulTx(aname, isbn, bprice);//如果mulTx和chekout、modifyBprice同一个业务方法  没办法为checkout和modify切入事务
	}
}
