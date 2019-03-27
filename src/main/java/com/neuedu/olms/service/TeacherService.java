package com.neuedu.olms.service;

import com.neuedu.olms.po.Teacher;

public interface TeacherService {
	/**
	 * 添加教师
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher);
	
	/**
	 * 查询电话号是否已注册
	 * @param tel
	 * @return
	 */
	public boolean hasTelExists(String tel);
	/**
	 * 用户登陆
	 * @param tel
	 * @param pwd
	 * @return
	 */
	public Teacher login(String tel,String pwd);
}
