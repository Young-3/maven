package org.young.entity;

import java.io.Serializable;

/**
 * @author Young
 * @version1.0
 */
public class Course implements Serializable {
	private int cId;
	private String cName;


	public Course() {
	}

	public Course(int cId, String cName) {
		this.cId = cId;
		this.cName = cName;

	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}


	@Override
	public String toString() {
		return this.cId+"-"+this.cName;
	}
}
