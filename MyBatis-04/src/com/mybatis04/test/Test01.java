package com.mybatis04.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis04.bean.Teacher;
import com.mybatis04.dao.TeacherMapper;


public class Test01 {
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory() throws Exception {
		String cofig="MyBatis-Config.xml";
		//加载 MyBatis全局配置文件 返回流
		InputStream inputStream=Resources.getResourceAsStream(cofig);
		//用输入流 构建sqlSessionFactory对象
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * 一级缓存 sqlSession级别  默认开启
	 * 第二次与第一次相同的查询   第二次默认查询 一级缓存
	 * 
	 * --测试查询条件不同 一级缓存失效
	 */
	@Test
	public void test01() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher01=teacherMapper.selectTeacherByPrimary(1);
		System.out.println("第一次按id查询教师信息:"+teacher01);
		System.out.println("============================>");
		
		Teacher teacher02=teacherMapper.selectTeacherByPrimary(2);
		System.out.println("第二次按id查询教师信息:"+teacher02);
		
	}
	/**
	 * 一级缓存失效测试的情况
	 * 1.两次相同查询之间有过 更新、删除、修改之一  一级缓存就会失效 (避免第二次查询到了过期数据 )
	 * 2.不同sqlSession之间
	 * 3.手动清除缓存 sqlSession.clearCache();
	 * 4.两次查询的查询条件不同
	 */
	@Test
	public void test02() {
		SqlSession sqlSession01=sqlSessionFactory.openSession();
		TeacherMapper teacherMapper=sqlSession01.getMapper(TeacherMapper.class);
		Teacher teacher01=teacherMapper.selectTeacherByPrimary(1);
		System.out.println("第一次按id查询教师信息:"+teacher01);
		System.out.println("============================>");
		//sqlSession.clearCache();
		SqlSession sqlSession02=sqlSessionFactory.openSession();
		TeacherMapper teacherMapper02=sqlSession02.getMapper(TeacherMapper.class);
		Teacher teacher02=teacherMapper02.selectTeacherByPrimary(1);
		System.out.println("第二次按id查询教师信息:"+teacher02);
	}
	/**
	 * 测试 两次查询间有 更新
	 */
	@Test
	public void test03() {
		SqlSession sqlSession01=sqlSessionFactory.openSession(true);
		TeacherMapper teacherMapper=sqlSession01.getMapper(TeacherMapper.class);
		Teacher teacher01=teacherMapper.selectTeacherByPrimary(1);
		System.out.println("第一次按id查询教师信息:"+teacher01);
		System.out.println("============================>");
		//更新
		Teacher teacher=new Teacher();
		teacher.setTeacherId(3);
		teacher.setCourse("英语");
		teacherMapper.updateTeacherDynamicParam(teacher);
		
		Teacher teacher02=teacherMapper.selectTeacherByPrimary(1);
		System.out.println("第二次按id查询教师信息:"+teacher02);
	}
}
