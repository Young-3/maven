package org.young.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Young
 * @version1.0
 */
public class StudentClass implements Serializable {
	private int classId;
	private  String className;
	private List<Student> students;

	public StudentClass() {
	}

	public StudentClass(int classId, String className, List<Student> students) {
		this.classId = classId;
		this.className = className;
		this.students = students;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


}
