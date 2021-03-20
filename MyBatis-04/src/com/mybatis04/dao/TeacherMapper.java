package com.mybatis04.dao;

import java.util.List;

import com.mybatis04.bean.Teacher;

public interface TeacherMapper {
	/**
	 * 根据主键id查询教师信息
	 * @param teacherId
	 * @return
	 */
	public Teacher selectTeacherByPrimary(Integer teacherId);
	/**
	 * 多条件组合查询
	 * @param teacher
	 * @return
	 */
	public List<Teacher> selectTeacherByManyParam(Teacher teacher);
	/**
	 * 根据id集合List查询教师信息 返回教师集合
	 * @param ids
	 * @return
	 */
	public List<Teacher> selectTeacherByIdIn(List<Integer>ids);
	/**
	 * 利用chioose标签 实现分支结构的条件查询
	 * @param teacher
	 * @return
	 */
	public List<Teacher> selectTeacherByChioose(Teacher teacher);
	/**
	 * 动态更新字段
	 * @param teacher
	 * @return
	 */
	public boolean updateTeacherDynamicParam(Teacher teacher);
}
