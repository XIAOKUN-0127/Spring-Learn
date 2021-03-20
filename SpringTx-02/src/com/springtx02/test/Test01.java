package com.springtx02.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.springtx02.bean.User;

public class Test01 {
	
	ApplicationContext ioc=new ClassPathXmlApplicationContext("tx02.xml");
	JdbcTemplate jdbcTemplate=ioc.getBean(JdbcTemplate.class);
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate=ioc.getBean(NamedParameterJdbcTemplate.class);
	//jdbcTemplate对象测试
	@Test
	public void test01() throws Exception {
		System.out.println(jdbcTemplate);
	}
	
	//插入数据
	@Test
	public void test02() throws Exception {
		String sql="insert into tb_user values(null,?,?)";
		int result=jdbcTemplate.update(sql,"测试插入01","010101");
		System.out.println("插入数据:"+result);
	}
	
	//查询数据,封装成对象   如果查询没结果 即报错 而不返回null
	@Test
	public void test03() {
		String sql="select * from tb_user where uid=?";
		RowMapper rowMapper=new BeanPropertyRowMapper(User.class);
		User user=(User) jdbcTemplate.queryForObject(sql, rowMapper, 2);
		System.out.println("查询的对象:"+user);
	}
	//查询数据,封装成List集合
	@Test
	public void test04() {
		String sql="select * from tb_user where uid>?";
		RowMapper rowMapper=new BeanPropertyRowMapper(User.class);
		List<User>users=jdbcTemplate.query(sql, rowMapper, 1);
		System.out.println("查询的list:"+users);
	}
	//查询id最大的值
	@Test
	public void test05() {
		String sql="select max(uid) from tb_user";
		int max=jdbcTemplate.queryForInt(sql);
		System.out.println("最大id:"+max);
	}
	//批量插入多条数据
	@Test
	public void test06() {
		String sql="insert into tb_user vlaues(null,?,?)";
		List<Object[]> inserts=new ArrayList<Object[]>();
		inserts.add(new Object[] {"批量插入测试01","批01"});
		inserts.add(new Object[] {"批量插入测试02","批02"});
		inserts.add(new Object[] {"批量插入测试03","批03"});
		jdbcTemplate.batchUpdate(sql, inserts);
	}
	
	//具名参数测试插入
	@Test
	public void test07() {
		String sql="insert into tb_user values(null,:name,:pwd)";
		Map<String,Object>paramMap=new HashMap<String, Object>();
		paramMap.put("name", "具名参数01");
		paramMap.put("pwd", "具名参数01pwd");
		int result=namedParameterJdbcTemplate.update(sql, paramMap);
		System.out.println("具名参数的测试:"+result);
	}
	//具名参数 SqlParameterSource为参数
	@Test
	public void test08() {
		String sql="insert into tb_user values(null,:uname,:upwd)";
		User user=new User();
		user.setUname("sqlparametersouce");
		user.setUpwd("sqlparametersouce");
		
		int result=namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
		System.out.println("SqlParameterSource的测试:"+result);
	}
}
