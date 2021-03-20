package com.mybatis02.dao;

import java.util.List;

import com.mybatis02.bean.Department;

public interface DepartmentMapper {
	/**
	 * 根据deptId查询部门信息 的简单方法 ===>分布查询使用
	 * @param deptId
	 * @return
	 */
	public Department getDeptSimple(Integer deptId);
	public Department getDeptSimple1(Integer deptId);
	
	/**
	 * 根据deptId查询部门信息包括部门的员工信息的集合
	 * @param deptId
	 * @return
	 */
	public Department getDeptAndEmps(Integer deptId);
}
