package com.mybatis02.test;

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

import com.mybatis02.bean.Employee;
import com.mybatis02.dao.EmployeeMapper;

/**
 * MyBatis传参问题
 * @author admin
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
	 * 单个参数时,#{任意名称} 都可以取到参数
	 */
	@Test
	public void test02SelectAndId() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Integer empId=1028;
		Employee employee=employeeMapper.getEmployee(empId);
		System.out.println("按id查询的员工信息:"+employee);
		sqlSession.close();
	}
	/**
	 * 报错 Parameter 'empId' not found. Available parameters are [arg1, arg0, param1, param2]
	 * 参数绑定 异常    
	 */
	@Test
	public void test01SelectAndIdAndName() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		String empName="mybatis02-testInsertWithEmpIdAfter";
		Integer empId=1028;
		Employee employee=employeeMapper.getEmployeeEmpIdAndEmpName(empId, empName);
		System.out.println("id和name组合查询的员工信息:"+employee);
		sqlSession.close();
	
	}
	/**
	 * Map为参数 MyBatis取值
	 */
	@Test
	public void test03SelectAndMap() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Map<String,Object>map=new HashMap<String, Object>();
		String empName="mybatis02-testInsertWithEmpIdAfter";
		Integer empId=1028;
		map.put("empId", empId);map.put("empName", empName);
		Employee employee=employeeMapper.getEmployeeAndMap(map);
		System.out.println("Map为参数查询的员工信息:"+employee);
		sqlSession.close();
	}
	/**
	 * 多个参数包含Employee
	 */
	@Test
	public void test04SelectAndManyParam() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Map<String,Object>map=new HashMap<String, Object>();
		String empName="mybatis02-testInsertWithEmpIdAfter";
		Integer id=1028;
		Employee employeep=new Employee();
		employeep.setEmail("mybatis02@qq.com");
		Employee employee=employeeMapper.getEmpAndIdAndNameAndEmpToEmail(id, empName, employeep);
		System.out.println("多个参数包含PoJo对象的查询员工信息:"+employee);
		sqlSession.close();
	}
	/**
	 * ${}的用途  除了参数位置可以使用#{}外  其他地方使用${}动态传值
	 */
	@Test
	public void test05SelectId() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		int id=employeeMapper.getTableId("tb_emp",1023);
		System.out.println("传入表名tb_emp查询id:"+id);
		sqlSession.close();
	}
	/**
	 * 查询所有员工信息返回List
	 */
	@Test
	public void test06GetList() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		List<Employee>emps=employeeMapper.getAllEmp();
		System.out.println("所有员工信息:"+emps);
		sqlSession.close();
	}
	/**
	 * 返回Map
	 */
	@Test
	public void test07SelectReturnMap() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Map<String,Object> map=employeeMapper.getReturnMap(1023);
		System.out.println("Map封装的员工信息:"+map);
		sqlSession.close();
	}
	/**
	 * Map封装多个员工信息
	 */
	@Test
	public void test07SelectMaps() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Map<Integer,Employee> maps=employeeMapper.getEmpMaps();
		System.out.println("Map封装多个员工信息:"+maps);
		sqlSession.close();
	}
	
	/**
	 * 自定义ResultMap
	 */
	@Test
	public void test08SelectResiltMap() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Employee employee=employeeMapper.getOneEmp(1023);
		System.out.println("自定义ResultMap为结果映射的查询:"+employee);
		sqlSession.close();
	}
}
