package com.springtx03.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springtx03.dao.BookDAO;

public class MulTxBiz {
	@Autowired
	BookBiz bookDAO;
	
	
	public void mulTx(String aname,String isbn,double bprice)  {
		
		
			bookDAO.checkout(aname, isbn);
		
			bookDAO.modifyBprice(isbn, bprice);
		
	}
}
