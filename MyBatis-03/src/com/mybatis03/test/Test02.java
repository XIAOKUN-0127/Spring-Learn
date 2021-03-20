package com.mybatis03.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class Test02 {

	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory() throws Exception {
		String cofig="MyBatis-Config.xml";
		//加载 MyBatis全局配置文件 返回流
		InputStream inputStream=Resources.getResourceAsStream(cofig);
		//用输入流 构建sqlSessionFactory对象
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}
	
}
