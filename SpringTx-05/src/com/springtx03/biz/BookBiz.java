package com.springtx03.biz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springtx03.dao.BookDAO;

public class BookBiz {
	@Autowired
	BookDAO bookDAO;
	
	public int checkout(String aname,String isbn)  {
		//获得库存 判断库存是否充足
		int stock=bookDAO.getStock(isbn);
		if(stock<=0) {
			return -1;
		}

		//减库存 
		int result=bookDAO.updateStock(isbn);
		//查询图书价格
		double bprice=bookDAO.getBprice(isbn);
		//查询余额
		int balance=bookDAO.getBalance(aname);
		if((balance-bprice)>=0) {
			//减余额
			result=bookDAO.updateBalance(aname, bprice);
			//int i=1/0;
			return result;
			
		}
		return -1;
	}
	
	public void modifyBprice(String isbn,double bprice) {
		bookDAO.modifyBPrice(isbn, bprice);
		int i=10/0;
	}
	
	
}
