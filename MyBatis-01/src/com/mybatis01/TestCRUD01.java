package com.mybatis01;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis01.bean.Employee;
import com.mybatis01.dao.EmployeeDAO;

public class TestCRUD01 {
	/**
	 * mybatis的事务提交默认为 不自动提交  setAutoCommit(false)
	 */
	static SqlSessionFactory sqlSessionFactory;
	static {
		String cofig="MyBatisConfig.xml";
		//加载 MyBatis全局配置文件 返回流
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(cofig);
			//用输入流 构建sqlSessionFactory对象  创建SqlSession的工厂
		    sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加
	 */
	@Test
	public void test01Insert() {
		//工厂创建一个sqlSession  代表和数据库的一次会话
		SqlSession sqlSession=sqlSessionFactory.openSession();		
		//根据接口类获得EmployeeDAO对象的代理对象
		EmployeeDAO employeeDAO=sqlSession.getMapper(EmployeeDAO.class);
		//输出sqlSession对象
		System.out.println("sqlSession连接对象:"+sqlSession);
		System.out.println("EmployeeDAO接口的代理对象:"+employeeDAO);
		//构建实体对象
		Employee employee=new Employee();
		employee.setEmpName("mTest02");
		employee.setGender("M");
		employee.setEmail("45623@qq.com");
		employee.setDeptId(2);
		int result=employeeDAO.insertEmployee(employee);
		sqlSession.commit();
		System.out.println("添加结果:"+result);
		sqlSession.close();
	}
	
	/**
	 * 查询
	 */
	@Test
	public void test02Select() {
		//工厂创建一个sqlSession  代表和数据库的一次会话
		SqlSession sqlSession=sqlSessionFactory.openSession();		
		//根据接口类获得EmployeeDAO对象的代理对象
		EmployeeDAO employeeDAO=sqlSession.getMapper(EmployeeDAO.class);
		Employee employee=employeeDAO.getEmployee(1023);
		System.out.println("id为1020的员工信息:"+employee);
		sqlSession.close();
	}
	/**
	 * 删除
	 */
	@Test
	public void test03Delete() {
		//工厂创建一个sqlSession  代表和数据库的一次会话
		SqlSession sqlSession=sqlSessionFactory.openSession();		
		//根据接口类获得EmployeeDAO对象的代理对象
		EmployeeDAO employeeDAO=sqlSession.getMapper(EmployeeDAO.class);
		boolean result=employeeDAO.deleteEmployee(1020);
		sqlSession.commit();
		sqlSession.close();
		System.out.println("删除的结果:"+result);
	}
	/**
	 * 修改
	 */
	@Test
	public void testUpdate() {
		//工厂创建一个sqlSession  代表和数据库的一次会话
		SqlSession sqlSession=sqlSessionFactory.openSession();		
		//根据接口类获得EmployeeDAO对象的代理对象
		EmployeeDAO employeeDAO=sqlSession.getMapper(EmployeeDAO.class);
		Employee employee=new Employee();
		employee.setEmpId(1021);
		employee.setEmpName("mTestupdate");
		employee.setGender("M");
		employee.setEmail("45623@qq.com");
		employee.setDeptId(2);
		int result=employeeDAO.updateEmployee(employee);
		sqlSession.commit();
		System.out.println("修改的结果:"+result);
	}
}
