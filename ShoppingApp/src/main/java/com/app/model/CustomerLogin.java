package com.app.model;

public class Customerlogin {
	private String cusfirstname;
	private String cuslastname;
	private String cusemail;
	private String cuspassword;
	public Customerlogin() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Customerlogin(String cusemail, String cuspassword) {
		super();
		this.cusemail = cusemail;
		this.cuspassword = cuspassword;
	}

	public Customerlogin(String cusfirstname, String cuslastname, String cusemail, String cuspassword) {
		this(cusemail,cuspassword);
		this.cusfirstname = cusfirstname;
		this.cuslastname = cuslastname;
	}

	public String getCusfirstname() {
		return cusfirstname;
	}
	public void setCusfirstname(String cusfirstname) {
		this.cusfirstname = cusfirstname;
	}
	public String getCuslastname() {
		return cuslastname;
	}
	public void setCuslastname(String cuslastname) {
		this.cuslastname = cuslastname;
	}
	public String getCusemail() {
		return cusemail;
	}
	public void setCusemail(String cusemail) {
		this.cusemail = cusemail;
	}
	public String getCuspassword() {
		return cuspassword;
	}
	public void setCuspassword(String cuspassword) {
		this.cuspassword = cuspassword;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cusemail == null) ? 0 : cusemail.hashCode());
		result = prime * result + ((cusfirstname == null) ? 0 : cusfirstname.hashCode());
		result = prime * result + ((cuslastname == null) ? 0 : cuslastname.hashCode());
		result = prime * result + ((cuspassword == null) ? 0 : cuspassword.hashCode());
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
		Customerlogin other = (Customerlogin) obj;
		if (cusemail == null) {
			if (other.cusemail != null)
				return false;
		} else if (!cusemail.equals(other.cusemail))
			return false;
		if (cusfirstname == null) {
			if (other.cusfirstname != null)
				return false;
		} else if (!cusfirstname.equals(other.cusfirstname))
			return false;
		if (cuslastname == null) {
			if (other.cuslastname != null)
				return false;
		} else if (!cuslastname.equals(other.cuslastname))
			return false;
		if (cuspassword == null) {
			if (other.cuspassword != null)
				return false;
		} else if (!cuspassword.equals(other.cuspassword))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Signupcus [cusfirstname=" + cusfirstname + ", cuslastname=" + cuslastname + ", cusemail=" + cusemail
				+ ", cuspassword=" + cuspassword + "]";
	}

}
