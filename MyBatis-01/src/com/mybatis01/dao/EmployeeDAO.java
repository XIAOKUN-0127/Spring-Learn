package com.mybatis01.dao;

import com.mybatis01.bean.Employee;
/**
 * Employee的数据访问类
 * @author admin
 *
 */
public interface EmployeeDAO {
	/**
	 * 根据emp_id查询Employee对象
	 * @param emp_id
	 * @return
	 */
	public Employee getEmployee(Integer emp_id);
	/**
	 * 根据emp_id修改Employee对象
	 * @param employee
	 * @return
	 */
	public int updateEmployee(Employee employee);
	/**
	 * 根据emp_id删除Employee对象
	 * @param emp_id
	 * @return
	 */
	public boolean deleteEmployee(Integer emp_id);
	/**
	 * 插入员工信息数据
	 * @param employee
	 * @return
	 */
	public int insertEmployee(Employee employee);
}
