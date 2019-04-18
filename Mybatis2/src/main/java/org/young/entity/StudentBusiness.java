package org.young.entity;

/**
 * @author Young
 * @version1.0
 */
public class StudentBusiness extends Student {
	private int cId;
	private String cName;


	public StudentBusiness() {
	}

	public StudentBusiness(int cId, String cName) {
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
		return super.toString()+"->course:"+this.cId+"-"+this.cName;
	}
}
