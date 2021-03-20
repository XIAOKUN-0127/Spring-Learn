package com.springtx03.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class BookDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 更新余额
	 * @param aname
	 * @param isbn
	 * @return
	 */
	public int updateBalance(String aname,double bprice) {
		String sql="update tb_account set balance=balance-? where aname=?";
		int result=jdbcTemplate.update(sql, bprice,aname);
		System.out.println("执行updateBalance方法...");
		return result;
	}
	/**
	 * 根据isbn获得图书单价
	 * @param isbn
	 * @return
	 */
	public double getBprice(String isbn) {
		String sql="select bprice from tb_book where isbn= ?";
		double bprice=(double) jdbcTemplate.queryForObject(sql,Double.class, isbn);
		System.out.println("执行getBprice方法...");
		return bprice;
	}
	/**
	 * 根据isbn获得图书库存
	 * @param isbn
	 * @return
	 */
	public int getStock(String isbn) {
		String sql="select stock from tb_stock where isbn=?";
		int stock=jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		System.out.println("执行getStock方法...");
		return stock;
	}
	/**
	 * 更新库存
	 * @param isbn
	 * @return
	 */
	public int updateStock(String isbn) {
		String sql="update tb_stock set stock=stock-1 where isbn=?";
		int result=jdbcTemplate.update(sql, isbn);
		System.out.println("执行updateStock方法 ..");
		return result;
	}
	/**
	 * 根据账户名称获得余额
	 * @param aname
	 * @return
	 */
	public int getBalance(String aname) {
		String sql="select balance from tb_account where aname= ? ";//数据库编码使得中文参数aname为乱码 查询为空即报异常
		int balance=jdbcTemplate.queryForObject(sql, Integer.class, aname);
		System.out.println("执行getBalance方法 ..");
		return balance;
	}
	
	public int modifyBPrice(String isbn,double bprice) {
		String sql="update tb_book set bprice=? where isbn=?";
		int result=jdbcTemplate.update(sql, bprice,isbn);
		System.out.println("modifyBPrice。。。修改价格事务方法");
		return result;
	}
}
