package com.app.model;

public class Employeelogin {
	private String empemail;
	private String emppassword;
	public Employeelogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employeelogin(String empemail,String emppassword) {
		super();
		this.empemail = empemail;
		this.emppassword = emppassword;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	public String getEmppassword() {
		return emppassword;
	}
	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}
	@Override
	public String toString() {
		return "EmployeeLogin [empemail=" + empemail + ", emppassword=" + emppassword + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empemail == null) ? 0 : empemail.hashCode());
		result = prime * result + ((emppassword == null) ? 0 : emppassword.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employeelogin other = (Employeelogin) obj;
		if (empemail == null) {
			if (other.empemail != null)
				return false;
		} else if (!empemail.equals(other.empemail))
			return false;
		if (emppassword == null) {
			if (other.emppassword != null)
				return false;
		} else if (!emppassword.equals(other.emppassword))
			return false;
		return true;
	}
	
	

}
