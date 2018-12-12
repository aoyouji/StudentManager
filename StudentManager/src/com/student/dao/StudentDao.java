package com.student.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;
import com.student.mapper.StudentMapperst;

/**
 *
 * StudentDao クラス
 *
 * @author Sui
 *
 */
public class StudentDao {


	// @Fields jdbcTemplate
	private JdbcTemplate jdbcTemplate;

	/**
	 * spring提供的类
	 *
	 * @param jdbcTemplate
	 * @param jdbcTemplate
	 *            返回值类型： void
	 */

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * すべての学生を検索する
	 *
	 * @return List<Student>
	 */

	public List<Student> queryAll() {
	  //SQLから学生情報を貰う
		String sql = "select id,name,birthday,age,score from student";
		return jdbcTemplate.query(sql, new StudentMapper());
	}

	/**
	 * すべての学生+先生を検索する
	 *　indexst.jsp
	 * @return List<Student>
	 */

	public List<Student> queryAllst() {
	  //SQLから学生情報を貰う
		String sql = "select\r\n" +
				"  student.id\r\n" +
				"  , student.name\r\n" +
				"  , student.birthday\r\n" +
				"  , student.age\r\n" +
				"  , student.score\r\n" +
				"  , teacher.id as teacherid\r\n" +
				"  , teacher.teachername\r\n" +
				"  , teacher.course \r\n" +
				"from\r\n" +
				"  student \r\n" +
				"  left join teacher \r\n" +
				"    on student.id = teacher.id";
		return jdbcTemplate.query(sql, new StudentMapperst());
	}

	/**
	 * 学生検索の方法
	 *
	 * @param name
	 * @return
	 */
	public List<Student> queryByName(String name) {
		String sql = "select id,name,birthday,age,score from student where name like'%" + name + "%'";
		List<Student> studentlist = new ArrayList();
		studentlist = jdbcTemplate.query(sql, new StudentMapper());
		return studentlist;
	}

	/**
	 * 学生検索の方法
	 *
	 * @param id
	 * @return
	 */
	public List<Student> queryById(int id) {
		String sql = "select id,name,birthday,age,score from student where id like  "+id+" " ;
		List<Student> studentlist = new ArrayList();
		studentlist = jdbcTemplate.query(sql, new StudentMapper());
		return studentlist;
	}

	/**
	 * 新規学生の増加
	 *
	 * @param student
	 * @return
	 */
	public boolean Addstudent(Student student) {
		String sql = "insert into student(id,name,birthday,age,score)values(0,?,?,?,?)";
		boolean s;
		// jdbcTemplate.update(sql,new Object,new int);
		s = jdbcTemplate.update(sql,
				new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore(),
						},
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE, }) == 1;
		return s;

	}

	/**
	 * 学生削除
	 *
	 * @param id
	 * @return
	 */
	public boolean Deletestudent(Integer id) {
		String sql = "delete from student where id=?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	/**
	 * 学生削除
	 *
	 * @param name
	 * @return
	 */
	public boolean Deletetudentbyname(String name) {
		String sql = "delete from student where name=?";
		return jdbcTemplate.update(sql, name) == 1;
	}

	/**
	 * 更新学生信息
	 *
	 * @param student
	 * @return 返回值类型： boolean
	 */
	public boolean updateStudent(Student student) {

		String sql = "update student set name=? ,age=?,birthday = ? ,score = ? where id = ?";
		Object stuObj[] = new Object[] { student.getName(), student.getAge(), student.getBirthday(), student.getScore(),
				student.getId() };

		return jdbcTemplate.update(sql, stuObj) == 1;
	}
}
