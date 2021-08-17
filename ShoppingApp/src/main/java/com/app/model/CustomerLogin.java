package com.app.model;

public class CustomerLogin {
	private String Cusemail;
	private String Cuspassword;
	public CustomerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerLogin(String cusemail, String cuspassword) {
		super();
		Cusemail = cusemail;
		Cuspassword = cuspassword;
	}
	public String getCusemail() {
		return Cusemail;
	}
	public void setCusemail(String cusemail) {
		Cusemail = cusemail;
	}
	public String getCuspassword() {
		return Cuspassword;
	}
	public void setCuspassword(String cuspassword) {
		Cuspassword = cuspassword;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cusemail == null) ? 0 : Cusemail.hashCode());
		result = prime * result + ((Cuspassword == null) ? 0 : Cuspassword.hashCode());
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
		CustomerLogin other = (CustomerLogin) obj;
		if (Cusemail == null) {
			if (other.Cusemail != null)
				return false;
		} else if (!Cusemail.equals(other.Cusemail))
			return false;
		if (Cuspassword == null) {
			if (other.Cuspassword != null)
				return false;
		} else if (!Cuspassword.equals(other.Cuspassword))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerLogin [Cusemail=" + Cusemail + ", Cuspassword=" + Cuspassword + "]";
	}

}
