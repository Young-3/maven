package org.young.entity;

/**
 * @author Young
 * @version1.0
 */
public class Student {

	private int stuId;
	private String stuName;
	private String stuPw;

	public Student() {
	}

	public Student(int stuId, String stuName) {
		this.stuId = stuId;
		this.stuName = stuName;
	}

	public Student(int stuId, String stuName, String stuPw) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuPw = stuPw;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPw() {
		return stuPw;
	}

	public void setStuPw(String stuPw) {
		this.stuPw = stuPw;
	}

	@Override
	public String toString() {
		return this.stuId+"-"+this.stuName+"-"+this.stuPw;
	}
}
