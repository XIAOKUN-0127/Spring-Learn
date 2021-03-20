package com.mybatis01;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 测试SqlSession对象的获得
 * @author admin
 *
 */
public class TestMyBatis01 {

	public static void main(String[] args) throws Exception {
		
		String cofig="MyBatisConfig.xml";
		//加载 MyBatis全局配置文件 返回流
		InputStream inputStream=Resources.getResourceAsStream(cofig);
		//用输入流 构建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		//工厂创建一个sqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//输出sqlSession对象
		System.out.println("sqlSession连接对象:"+sqlSession);
	}

}
