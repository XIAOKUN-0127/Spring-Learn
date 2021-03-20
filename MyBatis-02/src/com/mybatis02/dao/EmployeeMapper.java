package com.mybatis02.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.mybatis02.bean.Employee;
/**
 * Employee的数据访问类
 * @author admin
 *
 */
public interface EmployeeMapper {
	//根据empId查员工信息的简单方法
	public Employee getEmpSimple(Integer empId);
	/**
	 * 根据emp_id查询Employee对象
	 * @param emp_id
	 * @return
	 */
	public Employee getEmployee(Integer emp_id);
	
	/**
	 * 根据id和name组合查询
	 * @param emp_id
	 * @param emp_Name
	 * @return
	 */
	public Employee getEmployeeEmpIdAndEmpName(@Param("empId")Integer emp_id,@Param("empName")String emp_Name);
	
	/**
	 * 参数封装到Map集合作为MyBatis的参数
	 * @param map
	 * @return
	 */
	public Employee getEmployeeAndMap(Map<String,Object> map);
	/**
	 * 多个参数 包含 Employee
	 * @param id
	 * @param empName
	 * @param employee
	 * @return
	 */
	public Employee getEmpAndIdAndNameAndEmpToEmail(@Param("empId")Integer id,String empName,Employee employee);
	/**
	 * 根据传入的表名和id查询id值
	 * @param tableName
	 * @param id
	 * @return
	 */
	public int getTableId(@Param("tableName")String tableName,@Param("empId")Integer empId);
	/**
	 * 查询所有员工信息 返回List集合
	 * @return
	 */
	public List<Employee> getAllEmp();
	
	public List<Employee> getManyEmp1(Integer deptId);
	/**
	 * 查询返回Map  键为列名称  值为对应值
	 * @param empId
	 * @return
	 */
	public Map<String,Object> getReturnMap(@Param("empId")Integer empId);
	/**
	 * 将多个对象封装到Map
	 * @return
	 */
	@MapKey("empName")
	public Map<Integer,Employee> getEmpMaps();
	/**
	 * 自定义ResultMap
	 * @param empId
	 * @return
	 */
	public Employee getOneEmp(Integer empId);
	
	/**
	 * 联合查询 department.deptId的形式
	 * @param empId
	 * @return
	 */
	public Employee getEmpAndDept(Integer empId);
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
	
	/**
	 * 插入员工信息数据 插入前生成 自增的主键emp_id
	 * @param employee
	 * @return
	 */
	public int insertEmployeeWithEmpId(Employee employee);
}
