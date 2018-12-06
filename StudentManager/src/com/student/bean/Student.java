package com.student.bean;

/**
 * 学生のクラス
 *
 * @author xumin
 *
 */
public class Student {
	// 学生id
	private Integer id;
	// 学生姓名
	private String name;
	// 学生生年月日
	private String birthday;
	// 学生年齢
	private int age;
	// 学生成績
	private double score;
	// teacherid
	private Integer teacherid;
	// 先生姓名
	private String teachername;
	// 先生授業科目
	private String course;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Integer getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + ", score=" + score
				+ ", teacherid=" + teacherid + ", teachername=" + teachername + ", course=" + course + "]";
	}

	public Student(Integer id, String name, String birthday, int age, double score, Integer teacherid,
			String teachername, String course) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.score = score;
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.course = course;
	}

	public Student() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}




}
