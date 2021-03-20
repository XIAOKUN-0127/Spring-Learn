package com.mybatis01;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis01.bean.Employee;
import com.mybatis01.dao.EmployeeAnnotationDAO;
/**
 * mapper 的class指定接口   接口方法上标记注解
 * @author admin
 *
 */
public class TestAnnotationSelect01 {

	@Test
	public void testAnnotationSelect() throws Exception {
		String cofig="MyBatisConfig.xml";
		//加载 MyBatis全局配置文件 返回流
		InputStream inputStream=Resources.getResourceAsStream(cofig);
		//用输入流 构建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		//工厂创建一个sqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		EmployeeAnnotationDAO employeeAnnotationDAO=sqlSession.getMapper(EmployeeAnnotationDAO.class);
		Employee employee =employeeAnnotationDAO.getEmployee(1023);
		System.out.println("注解版查询:"+employee);
		sqlSession.close();
	}
}
