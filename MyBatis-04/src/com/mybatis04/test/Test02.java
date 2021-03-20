package com.mybatis04.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis04.bean.Teacher;
import com.mybatis04.dao.TeacherMapper;
/**
 * 二级缓存测试     二级缓存是命名空间范围缓存  同一个命名空间共享
 *  一级缓存 是sqlSession范围(线程)缓存  同一个会话共享
 * @author admin
 * 
 * 一级缓存和二级缓存共存是  查询流程
 *   首先查询二级缓存是否有数据  ->无-> 一级缓存 ->无 ->发送sql语句
 *   	一级缓存sqlSession失效前 将一级缓存的数据放入二级缓存
 *
 */
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
	/**
	 * 查询了一次 就放入一级缓存   关闭第一次连接后 第二次查询从二级缓存查询 如果没有就发sql
	 */
	@Test
	public void test01() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher01=teacherMapper.selectTeacherByPrimary(1);
		System.out.println("第一次按id查询教师信息:"+teacher01);
		System.out.println("============================>");
		sqlSession.close();//关闭后 将一级缓存数据存入二级缓存
		
		SqlSession sqlSession02=sqlSessionFactory.openSession();
		TeacherMapper teacherMapper02=sqlSession02.getMapper(TeacherMapper.class);
		Teacher teacher02=teacherMapper02.selectTeacherByPrimary(1);
		System.out.println("第二次按id查询教师信息:"+teacher02);
	}
	
	@Test
	public void test02() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher01=teacherMapper.selectTeacherByPrimary(1);
		System.out.println("第一次按id查询教师信息:"+teacher01);
		System.out.println("============================>");
		sqlSession.close();//关闭后 将一级缓存数据存入二级缓存
		
		SqlSession sqlSession02=sqlSessionFactory.openSession();
		TeacherMapper teacherMapper02=sqlSession02.getMapper(TeacherMapper.class);
		Teacher teacher02=teacherMapper02.selectTeacherByPrimary(1);
		System.out.println("第二次按id查询教师信息:"+teacher02);
	}
}
