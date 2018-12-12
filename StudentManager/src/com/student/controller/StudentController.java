package com.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.student.bean.Student;
import com.student.dao.StudentDao;
import com.teacher.bean.Teacher;
import com.teacher.dao.TeacherDao;
/**
 *
 * @author jiangdang
 *
 */
@Controller
public class StudentController {
	private JdbcTemplate jdbcTemplate;
//
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 *
	 * 从数据库中获取全部学生信息，将数据返回给主页index,jsp
	 *
	/**学生検索方法
	 * @param model
	 * @return 返回值类型： String
	 */
	@RequestMapping(value = "/all")
	public String queryAll(Model model) {
		//フィルダー情報の配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		StudentDao studao = (StudentDao) context.getBean("dao");
		//新学生リストを生成する
		ArrayList<Student> studentList = new ArrayList<Student>();
		//studentdaoから貰ったqueryAll方法で学生情報をstudentlistへ戻す
		studentList = (ArrayList<Student>) studao.queryAll();
     //web(index)へ学生情報を戻す
		model.addAttribute("students", studentList);
		return "index";

	}

	/**
	 *
	 * 从数据库中获取全部学生+先生信息，将数据返回给主页indexｓt,jsp
	 *
	/**検索方法
	 * @param model
	 * @return 返回值类型： String
	 */
	@RequestMapping(value = "/allst")
	public String queryAllst(Model model) {
		//フィルダー情報の配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		StudentDao studao = (StudentDao) context.getBean("dao");
		//新学生リストを生成する
		ArrayList<Student> studentList = new ArrayList<Student>();
		//studentdaoから貰ったqueryAll方法で学生情報をstudentlistへ戻す
		studentList = (ArrayList<Student>) studao.queryAllst();
		//web(index)へ学生情報を戻す
		model.addAttribute("students", studentList);
		return "indexst";

	}

	/**
	 * 通过姓名查找学生，使用模糊查找，将结果返回给index.jsp
	 *
	 * @param name
	 * @param model
	 * @return 返回值类型： String
	 */

	@RequestMapping(value = "/queryByName")
	public String queryByName(String name, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryByName(name));
		// 画面へ戻す
		return "index";

	}

	/**
	 * 通过id查找学生，将结果返回给index.jsp
	 *
	 * @param id
	 * @param model
	 * @return 返回值类型：int
	 */

	@RequestMapping(value = "/queryById")
	public String queryById(int id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryById(id));
		// 画面へ戻す
		return "index";

	}
/*
 * 新規学生の追加
 */
	@RequestMapping(value = "/add")

	public String Addstudent(String name, String birthday, String age,String score,Model model) {
		 //フィルダー情報を配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//容器(ioc)からdaoを貰う
		StudentDao dao = (StudentDao) context.getBean("dao");
		//新学生対象を生成する
		Student student = new Student();
     //学生属性をセットする
		student.setName(name);
		student.setBirthday(birthday);
		student.setAge(Integer.valueOf(age));
		student.setScore(Double.valueOf(score));
		//DaoからaddStudentの方法を取り、使用する
		boolean result = dao.Addstudent(student);

		//成功・失敗するかを判断
		if (result) {
			model.addAttribute("msg", "<script>alert('添付成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('添付失敗')</script>");

		}
		//web(index)へ学生情報を戻す
		model.addAttribute("students", dao.queryAll());
		return "index";
	}
/*
 * 学生の削除
 */
	//学生削除の方法
	@RequestMapping(value = "/deleteById")
	public String Deletetudent(String id, Model model) {
		//フィルダーの情報を配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//容器(context)からdaoを貰う
		StudentDao dao = (StudentDao) context.getBean("dao");
		//Daoの中の削除方法を取り、使用
		boolean result = dao.Deletestudent(Integer.parseInt(id));
		//成功・失敗するかを判断
		if (result) {
			model.addAttribute("msg", "<script>alert('削除成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('削除失敗')</script>");
		}


		model.addAttribute("students", dao.queryAll());
		return "index";
	}

	@RequestMapping(value = "/deleteByName")
	public String Deletetudentbyname(String name, Model model) {
		//フィルダーの情報を配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//容器(context)からdaoを貰う
		StudentDao dao = (StudentDao) context.getBean("dao");
		//Daoの中の削除方法を取り、使用
		boolean result = dao.Deletetudentbyname(name);
		//成功・失敗するかを判断
		if (result) {
			model.addAttribute("msg", "<script>alert('削除成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('削除失敗')</script>");
		}
		model.addAttribute("students", dao.queryAll());
		return "index";
	}

	/**学生の更新
	@RequestMapping(value = "/update")
	 * @param id
	 * @param name
	 * @param birthday
	 * @param age
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update")
	public String updateStudent(String id, String name, String birthday, String age,String score, Model model) {
		//フィルダー情報の配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//容器(context)からdaoを貰う
		StudentDao dao = (StudentDao) context.getBean("dao");
		//新学生対象を生成する
		Student student = new Student();
		//学生属性をセットする(例：String id, String name, String birthday, String age, String score)
		student.setId(Integer.parseInt(id));
		student.setName(name);
		student.setBirthday(birthday);
		student.setAge(Integer.valueOf(age));
		student.setScore(Double.valueOf(score));
		//DaoからupdateStudentの方法を取り、使用する
		boolean result = dao.updateStudent(student);
       //成功するか失敗するかを判断する
		if (result) {
			model.addAttribute("msg", "<script>alert('更新成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('更新失敗！')</script>");
		}
       //	jsp(Web)へ情報を戻す
		model.addAttribute("students", dao.queryAll());
		return "index";
	}

	@RequestMapping(value = "/myajax", produces = "application/json;charset=UTF-8")
	public void getAjax(HttpServletRequest request, HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studao = (StudentDao) context.getBean("dao");
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) studao.queryAll();
		JSONArray data = new JSONArray(); //  List
		for (Student stu : studentList) {
			JSONObject jsonObject = new JSONObject(); // Map
			jsonObject.put("id", stu.getId());
			jsonObject.put("name", stu.getName());
			jsonObject.put("birthday", stu.getBirthday());
			jsonObject.put("age", stu.getAge());
			jsonObject.put("score", stu.getScore());
			data.add(jsonObject);
		}
		obj.put("result", true);
		obj.put("data", data);
		try {
			response.setContentType("application/json");
			response.getWriter().write(obj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/allTeacher")
	public String queryteacherAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao teacherdao = (TeacherDao) context.getBean("teacherDao");
		ArrayList<Teacher> teacherlist = new ArrayList<Teacher>();
		teacherlist = (ArrayList<Teacher>) teacherdao.queryteaAll();
		model.addAttribute("teachers", teacherlist);
		return "teacher";
	}



}
