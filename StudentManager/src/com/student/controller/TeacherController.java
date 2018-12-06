//package com.student.controller;
//
//import java.util.ArrayList;
//
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.teacher.bean.Teacher;
//import com.teacher.dao.TeacherDao;
//
//public class TeacherController {
//	/**
//	 *
//	 */
//
//	@RequestMapping(value = "/allTeacher")
//	public String queryAll(Model model) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		TeacherDao teacherdao = (TeacherDao) context.getBean("teacherDao");
//		ArrayList<Teacher> teacherlist = new ArrayList<Teacher>();
//		teacherlist = (ArrayList<Teacher>) teacherdao.queryAll();
//		model.addAttribute("teachers", teacherlist);
//		return " teacher";
//
//	}
//
//}
