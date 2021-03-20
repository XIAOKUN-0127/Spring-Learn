package com.mybatis03.test;

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

import com.mybatis03.bean.Teacher;
import com.mybatis03.dao.TeacherMapper;


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
	 * 按主键查询教师信息
	 */
	@Test
	public void test01SelectByPrimary() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher=teacherMapper.selectTeacherByPrimary(2);
		System.out.println("按主键查询教师信息:"+teacher);
	}
	
	
	/**
	 * 组合查询教师信息
	 */
	@Test
	public void test02SelectByManyParam() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Teacher teacher=new Teacher();
		int id=1;
		String name="李";
		String course="化学";
		String address="香洲";
		Date birthday=new Date();
		System.out.println("日期:"+birthday);
		//teacher.setTeacherId(id);
		//teacher.setTeacherName(name);
		teacher.setAddress(address);
		//teacher.setCourse(course);
		//teacher.setBirthday(birthday);
		TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> teachers=teacherMapper.selectTeacherByManyParam(teacher);
		System.out.println("组合查询教师信息:"+teachers);
	}
	
	/**
	 * 根据select..from..where id in(1,23,3,4)规则查询的教师信息集合
	 */
	@Test
	public void test03SelectByIdIn() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);ids.add(10);ids.add(4);
		TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> teachers=teacherMapper.selectTeacherByIdIn(ids);
		System.out.println("根据in规则查询的教师信息集合:"+teachers);
	}
	
	/**
	 * chioose查询教师信息
	 */
	@Test
	public void test03SelectByChioose() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Teacher teacher=new Teacher();
		int id=1;
		String name="李";
		String course="化学";
		String address="%香洲%";
		Date birthday=new Date();
		System.out.println("日期:"+birthday);
		//teacher.setTeacherId(id);
		//teacher.setTeacherName(name);
		teacher.setAddress(address);
		//teacher.setCourse(course);
		//teacher.setBirthday(birthday);
		TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> teachers=teacherMapper.selectTeacherByChioose(teacher);
		System.out.println("chioose查询教师信息:"+teachers);
	}
	/**
	 * 动态更新教师信息
	 */
	@Test
	public void test04UpdateByIf() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Teacher teacher=new Teacher();
		int id=1;
		String name="赵婉莹";
		String course="化学";
		String address="%香洲%";
		Date birthday=new Date();
		System.out.println("日期:"+birthday);
		teacher.setTeacherId(id);
		teacher.setTeacherName(name);
		//teacher.setAddress(address);
		//teacher.setCourse(course);
		teacher.setBirthday(birthday);
		TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
		boolean result=teacherMapper.updateTeacherDynamicParam(teacher);
		System.out.println("动态更新教师信息结果:"+result);
		sqlSession.close();
	}
}
