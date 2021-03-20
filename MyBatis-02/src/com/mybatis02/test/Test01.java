package com.mybatis02.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis02.bean.Employee;
import com.mybatis02.dao.EmployeeMapper;
/**
 * 获得自增主键列的值  useGeneratedKeys=true  keyProperty="实体类属性"
 * <selectkey keyProperty=""> order :before、after
 * @author admin
 *
 */
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
	
	@Test
	public void testInsert() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Employee employee=new Employee();
		employee.setEmpName("mybatis02-testInsert3");
		employee.setGender("s");
		employee.setEmail("mybatis02@qq.com");
		employee.setDeptId(3);
		int result=employeeMapper.insertEmployee(employee);
		System.out.println("员工信息添加结果:"+result);
		sqlSession.close();
		System.out.println("id:"+employee.getEmpId());
	}
	
	@Test
	public void testInsertWithEmpId() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Employee employee=new Employee();
		employee.setEmpName("mybatis02-testInsertWithEmpIdAfter2");
		employee.setGender("s");
		employee.setEmail("mybatis02@qq.com");
		employee.setDeptId(3);
		int result=employeeMapper.insertEmployeeWithEmpId(employee);
		System.out.println("员工信息添加结果:"+result);
		sqlSession.close();
		System.out.println("id:"+employee.getEmpId());
	}
}
