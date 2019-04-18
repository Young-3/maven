package org.young.entity;

/**
 * @author Young
 * @version1.0
 */
public class Student {

	private int stuId;
	private String stuName;
	private String stuPw;
	private boolean stuSex;
	private Address address;
	private String gName;
	private Course course;
	private StudentClass studentClass;



	public Student() {
	}

	public Student(int stuId, String stuName, boolean stuSex, String gName) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.gName = gName;
	}

	public Student(int stuId, String stuName, boolean stuSex, Address address, Course course, StudentClass studentClass) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.address = address;
		this.course = course;
		studentClass = studentClass;
	}

	public Student(int stuId, String stuName, boolean stuSex, Address address, Course course) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.address = address;
		this.course = course;

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

	public boolean isStuSex() {
		return stuSex;
	}

	public void setStuSex(boolean stuSex) {
		this.stuSex = stuSex;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public StudentClass getAclass() {
		return studentClass;
	}

	public void setAclass(StudentClass aclass) {
		studentClass = aclass;
	}

	@Override
	public String toString() {
		return this.stuId+"-"+this.stuName+"-"+this.stuSex+"-"+this.address.getHomeAddress()+"-"+this.address.getSchoolAddress()+"->course:"+this.course;//+"-"+this.address.getHomeAddress()+"-"+this.address.getSchoolAddress()
	}
}
