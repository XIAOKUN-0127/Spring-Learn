package com.springtx03.biz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springtx03.dao.BookDAO;
@Service
public class BookBiz {
	@Autowired
	BookDAO bookDAO;
	/**
	 * 图书购买结算流程  : 减库存(判断库存充足)、减余额(余额充足)、同时成功和失败
	 * @param aname 用户账号
	 * @param isbn 购买的图书isbn
	 * @return
	 */
	/**
	 * 事务细节属性
	 * isolation  事务隔离级别
	 * 并发问题：脏读、不可重复读、幻读
	 *   读未提交
	 *   读已提交
	 *   可重复读
	 *   串行化
	 * propagation 事务传播行为
	 * timeout 超时：事务自动终止并回滚
	 * readonly(以秒为单位) 只读：设置事务为只读事务；只允许select的操作
	 * 	默认为false,设为true可以优化事务，加快查询速度，不管事务一套
	 * noRollbackFor-class:指定那些异常不回滚
	 * 事务 的编译时异常默认不回滚  运行时异常默认回滚
	 *   异常分为:编译时异常(检查异常)和运行时异常(非检查异常)
	 * @throws Exception 
	 */
	//java.lang.ArithmeticException
	@Transactional(rollbackFor = {FileNotFoundException.class})
	public int checkout(String aname,String isbn) throws Exception {
		//获得库存 判断库存是否充足
		int stock=bookDAO.getStock(isbn);
		if(stock<=0) {
			return -1;
		}
		Thread.sleep(3000);
		//减库存 
		int result=bookDAO.updateStock(isbn);
		//查询图书价格
		double bprice=bookDAO.getBprice(isbn);
		//查询余额
		int balance=bookDAO.getBalance(aname);
		if((balance-bprice)>=0) {
			//减余额
			result=bookDAO.updateBalance(aname, bprice);
			//int s=1/0;
			new FileInputStream("D:/sss.ss");
			return result;
			
		}
		return -1;
	}
}
