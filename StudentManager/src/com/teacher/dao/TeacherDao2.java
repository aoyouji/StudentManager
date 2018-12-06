//package com.teacher.dao;
//
//import java.sql.Types;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import com.student.bean.Student;
//import com.student.mapper.StudentMapper;
//import com.student.mapper.TeacherMapper;
//import com.teacher.bean.Teacher;
//
//public class TeacherDao2 {
//
//	/**
//	 * @Fields jdbcTemplate
//	 */
//	private JdbcTemplate jdbcTemplate;
//
//	/**
//	 * spring提供的类
//	 *
//	 * @param jdbcTemplate
//	 *            返回值类型： void
//	 */
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	/**
//	 * 查询所有先生
//	 *
//	 * @return 返回值类型： List<Teacher>
//	 */
//	public List<Teacher> queryAll() {
//		String sql = "select id,teachername,course from teacher";
//		// MySqlからteacherListを取得
//		ArrayList<Teacher> teacherList = (ArrayList<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());
//
//		// 先生の1個ずつ取り出す
//		// 空teacherMapを生成する
//		HashMap<Integer, Teacher> teachermap = new HashMap<Integer, Teacher>();
//		int i = 0;
//		for (Teacher teacher : teacherList) {
//			// 先生の1個ずつ渡してPrintStudentメソッドを呼び出し、表示処理
//			i = i + 1;
//			teachermap.put(i, teacher);
//		}
//
//		for (Teacher stu : teachermap.values()) {
//			// 先生の1個ずつ渡してPrintStudentメソッドを呼び出し、表示処理
//			System.out.println(teachermap);
//		}
//		// 一番大大きなidを印刷
//		int maxTeacherId = CalculateMaxId(teachermap);
//		System.out.println("一番大大きなid:" + maxTeacherId);
//
//		return teacherList;
//	}
//
//	private static int CalculateMaxId(HashMap<Integer, Teacher> teachermap) {
//		// TODO 自動生成されたメソッド・スタブ
//		int maxTeacherId = 0;
//		// foreach（拡張for文）での書き方
//		for (Teacher teacher : ((Map<Integer, Teacher>) teachermap).values()) {
//			// 学生の年齢を取り出して、合計する
//			if (maxTeacherId < teacher.getId()) {
//				maxTeacherId = teacher.getId();
//			}
//
//		}
//		// 先生idの最大値を返す
//		return maxTeacherId;
//	}
//
//	/**
//	 * 通过姓名查询
//	 *
//	 * @param name
//	 * @return 返回值类型： List<Teacher>
//	 */
//	public List<Teacher> queryByName(String name) {
//		String sql = "select id,teachername,course  from teacher where teachername like '%" + name + "%'";
//
//		return jdbcTemplate.query(sql, new TeacherMapper());
//	}
//
//	/**
//	 * 添加先生
//	 *
//	 * @param teacher
//	 * @return 返回值类型： boolean
//	 */
//	public boolean addTeacher(Teacher teacher) {
//		String sql = "insert into teacher(id,teachername,course) values(0,?,?)";
//
//		return jdbcTemplate.update(sql, new Object[] { teacher.getTeachername(), teacher.getCourse() },
//				new int[] { Types.VARCHAR, Types.VARCHAR}) == 1;
//	}
//
//	/**
//	 * 删除先生
//	 *
//	 * @param id
//	 * @return 返回值类型： boolean
//	 */
//	public boolean deleteTeacher(Integer id) {
//
//		String sql = "delete from teacher where id = ?";
//		return jdbcTemplate.update(sql, id) == 1;
//	}
//
//	/**
//	 * 更新先生信息
//	 *
//	 * @param teacher
//	 * @return 返回值类型： boolean
//	 */
//	public boolean updateTeacher(Teacher teacher) {
//
//		String sql = "update  teacher set teachername=?,course = ? where id=?";
//		Object stuObj[] = new Object[] {  teacher.getTeachername(), teacher.getCourse() ,teacher.getId()};
//
//		return jdbcTemplate.update(sql, stuObj) == 1;
//	}
//
//	/**
//	 * 先生idの平均値
//	 *
//	 * @param Teacher
//	 *            hashmap return 先生idの平均値
//	 *
//	 */
//	private static int averTeacherId(ArrayList<Teacher> teacherList) {
//		int sum = 0;
//		// foreach（拡張for文）での書き方
//		for (Teacher teacher : teacherList) {
//			// 先生idを取り出して、合計する
//			sum = sum + teacher.getId();
//		}
//		// 先生idの平均値を返す
//		return sum / teacherList.size();
//
//	}
//
//	/**
//	 * 先生の情報を印刷する
//	 *
//	 * @param Teacher
//	 *            return
//	 */
//	private static void PrintTeacher(Teacher teacher) {
//		System.out.println("Id" + teacher.getId());
//		System.out.println("Name" + teacher.getTeachername());
//		System.out.println("Course" + teacher.getCourse());
//
//	}
//
//}
