package com.mybatis01;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis01.bean.Employee;
import com.mybatis01.dao.EmployeeDAO;

/**
 * 测试根据emp_id查询员工信息
 * @author admin
 *
 */
public class TestMyBatis02 {

	public static void main(String[] args) throws Exception {
		String cofig="MyBatisConfig.xml";
		//加载 MyBatis全局配置文件 返回流
		InputStream inputStream=Resources.getResourceAsStream(cofig);
		//用输入流 构建sqlSessionFactory对象  创建SqlSession的工厂
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		//工厂创建一个sqlSession  代表和数据库的一次会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//输出sqlSession对象
		System.out.println("sqlSession连接对象:"+sqlSession);
		//根据接口类获得EmployeeDAO对象的代理对象
		EmployeeDAO employeeDAO=sqlSession.getMapper(EmployeeDAO.class);
		System.out.println("EmployeeDAO接口的代理对象:"+employeeDAO);
		//调用查询方法
		Integer emp_id=1;
		Employee employee=employeeDAO.getEmployee(emp_id);
		System.out.println("查询出的emp_id=1的员工对象信息:"+employee);
		//selectOne的方法查询员工信息
		Object obj=sqlSession.selectOne("com.mybatis01.dao.EmployeeDAO.getEmployee",1);
		System.out.println("selectOne的方法查询员工信息:"+obj);
		//关闭连接
		sqlSession.close();
	}

}
