package com.springtx03.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springtx03.dao.BookDAO;
@Service
public class MulTxBiz {
	@Autowired
	BookBiz bookDAO;
	
	/**
	 * 测试一个事务方法嵌套多个事务方法
	 * @param aname
	 * @param isbn
	 * @param bprice
	 * @throws Exception
	 */
	@Transactional
	public void mulTx(String aname,String isbn,double bprice)  {
		
		
			bookDAO.checkout(aname, isbn);
		
			bookDAO.modifyBprice(isbn, bprice);
		
	}
}
