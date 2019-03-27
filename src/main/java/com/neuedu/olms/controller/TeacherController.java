package com.neuedu.olms.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.olms.po.Teacher;
import com.neuedu.olms.service.TeacherService;
import com.neuedu.olms.util.C;
import com.neuedu.olms.web.ApiResult;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@GetMapping("/test")
	public String test() {
		return "hello world";
	}
	/**
	 * ��֤�绰���Ƿ����
	 * @param tel
	 * @return  ���ڷ���true������false
	 */
	@GetMapping("/validTel/{tel}")
	public ApiResult hasExistTel(@PathVariable("tel") String tel) {
		boolean rs= teacherService.hasTelExists(tel);
		return ApiResult.build().setData(rs);
	}
	@PostMapping("/add")
	public ApiResult addTeacher(@Valid  Teacher teacher) {
		teacherService.addTeacher(teacher);
		return ApiResult.build();
		//teacherMapper.add(teacher);
	}
	@PostMapping("/login")
	public ApiResult login(HttpSession session,@RequestParam("tel")String tel,@RequestParam("pwd")String pwd) {
		Teacher teacher = teacherService.login(tel, pwd);
		session.setAttribute(C.USER_FLAG, teacher);
		Map<String,String> mp = new HashMap<String,String>();
		mp.put("token", teacher.getTokenEntity().getToken());
		return ApiResult.build().setData(mp);

	}
}
