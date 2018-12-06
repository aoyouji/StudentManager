package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.student.bean.Student;

/**
 * StudentMapper数据库映射
 * @ClassName StudentMapper
 */

public class StudentMapperst implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();

		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setBirthday(dateToString(rs.getDate("birthday")));
		student.setAge(rs.getInt("age"));
		student.setScore(rs.getDouble("score"));
		student.setTeacherid(rs.getInt("teacherid"));
		student.setTeachername(rs.getString("teachername"));
		student.setCourse(rs.getString("course"));
		return student;
	}

	/**
	 * 日付から、文字列に変換する。
	 *
	 * @param date 日付.
	 * @return 文字列.
	 */
	private String dateToString(Date date) {

		String dateStr = null;
		if (date != null) {
			dateStr = new SimpleDateFormat("yyyy/MM/dd").format(date);
		} else {
			dateStr = "";
		}
		return dateStr;
	}
}

//	/**
//	   * 获取日期
//	   * @return 返回日期字符串格式yyyy-MM-dd
//	   * @throws ParseException
//	   */
//	private String getStringDate(String birthday) {
//
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date dateString = new Date();
//		String strRtnDate = "";
//		try {
//			dateString = formatter.parse(birthday);
//			strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return strRtnDate;
//	}
//
