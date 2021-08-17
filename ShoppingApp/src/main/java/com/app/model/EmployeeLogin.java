package com.app.model;

public class EmployeeLogin {
	private String empemail;
	private String empfirstname;
	private String emplastname;
	private int emppassword;
	public EmployeeLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeLogin(String empemail, String empfirstname, String emplastname, int emppassword) {
		super();
		this.empemail = empemail;
		this.empfirstname = empfirstname;
		this.emplastname = emplastname;
		this.emppassword = emppassword;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	public String getEmpfirstname() {
		return empfirstname;
	}
	public void setEmpfirstname(String empfirstname) {
		this.empfirstname = empfirstname;
	}
	public String getEmplastname() {
		return emplastname;
	}
	public void setEmplastname(String emplastname) {
		this.emplastname = emplastname;
	}
	public int getEmppassword() {
		return emppassword;
	}
	public void setEmppassword(int emppassword) {
		this.emppassword = emppassword;
	}
	@Override
	public String toString() {
		return "EmployeeLogin [empemail=" + empemail + ", empfirstname=" + empfirstname + ", emplastname=" + emplastname
				+ ", emppassword=" + emppassword + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empemail == null) ? 0 : empemail.hashCode());
		result = prime * result + ((empfirstname == null) ? 0 : empfirstname.hashCode());
		result = prime * result + ((emplastname == null) ? 0 : emplastname.hashCode());
		result = prime * result + emppassword;
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
		EmployeeLogin other = (EmployeeLogin) obj;
		if (empemail == null) {
			if (other.empemail != null)
				return false;
		} else if (!empemail.equals(other.empemail))
			return false;
		if (empfirstname == null) {
			if (other.empfirstname != null)
				return false;
		} else if (!empfirstname.equals(other.empfirstname))
			return false;
		if (emplastname == null) {
			if (other.emplastname != null)
				return false;
		} else if (!emplastname.equals(other.emplastname))
			return false;
		if (emppassword != other.emppassword)
			return false;
		return true;
	}
	
	

}
