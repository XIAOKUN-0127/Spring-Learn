package com.mybatis02.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis02.bean.Department;
import com.mybatis02.bean.Employee;
import com.mybatis02.dao.DepartmentMapper;
import com.mybatis02.dao.EmployeeMapper;

public class Test03 {

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
	 * 1对1 级联方式 为复杂对象映射值 department.deptId
	 */
	@Test
	public void test01EDS() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Employee employee=employeeMapper.getEmpAndDept(1023);
		System.out.println("联合查询："+employee);
		sqlSession.close();
	}
	/**
	 * association 一对一关联的复杂对象(对象的属性是一个对象)映射
	 */
	@Test
	public void test02EDS2() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Employee employee=employeeMapper.getEmpAndDept(1023);
		System.out.println("联合查询："+employee);
		sqlSession.close();
	}
	
	/**
	 *  collection集合复杂对象查询处理
	 */
	@Test
	public void test03DeptAndEmps() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
		Department department=departmentMapper.getDeptAndEmps(3);
		System.out.println("联合查询集合："+department);
		sqlSession.close();
	}
	
	/**
	 *  association的分步查询
	 */
	@Test
	public void test04DeptAndEmpsSimple() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Employee employee=employeeMapper.getEmpSimple(1023);
		System.out.println("association的分步查询："+employee.getEmpName());
		System.out.println("association的分步查询："+employee.getDepartment());
		sqlSession.close();
	}
	
	/**
	 *  collection的分步查询
	 */
	@Test
	public void test05CollectionPart() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
		Department department=departmentMapper.getDeptSimple1(3);
		System.out.println("collection的分步查询："+department.getDeptName());
		sqlSession.close();
	}
	
	
}
