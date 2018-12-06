/**
 *
 */
package com.teacher.bean;

/**
 * 先生クラス
 * @author xumin
 *
 */
public class Teacher2 {

	private int id;// id
	private String teachername;// 名氏
	private String course;// 授業

	/**id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * id
	 * @param id
	 *            セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 先生名teachername
	 * @return teachername
	 */
	public String getTeachername() {
		return teachername;
	}

	/**
	 * @param teachername
	 *            セットする teachername
	 */
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	/**　授業
	 * @return course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            セットする course
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * 先生Newの時使用するMethod
	 * @param id
	 * @param teachername
	 * @param course
	 */
	public Teacher2(int id, String teachername, String course) {
		super();
		this.id = id;
		this.teachername = teachername;
		this.course = course;
	}

	/**
	 *
	 *先生Newの時使用するMethod
	 */
	public Teacher2() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teachername=" + teachername + ", course=" + course + ", getId()=" + getId()
				+ ", getTeachername()=" + getTeachername() + ", getCourse()=" + getCourse() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}


