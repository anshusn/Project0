package com.app.model;

public class Customerdetails {
	private int id;
	private String name;
	private String email;
	private String Address;
	private String Gender;
	private int loginid;
	private Customerlogin customerlogin;
	public Customerdetails(int id,String name, String email, String address, String gender,int loginid) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
		this.Address = address;
		this.Gender = gender;
		this.loginid=loginid;
	}
	public Customerdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getLoginid() {
		return loginid;
	}
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}
	public Customerlogin getCustomerlogin() {
		return customerlogin;
	}
	public void setCustomerlogin(Customerlogin customerlogin) {
		this.customerlogin = customerlogin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		this.Gender = gender;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((Gender == null) ? 0 : Gender.hashCode());
		result = prime * result + ((customerlogin == null) ? 0 : customerlogin.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + loginid;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Customerdetails other = (Customerdetails) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (Gender == null) {
			if (other.Gender != null)
				return false;
		} else if (!Gender.equals(other.Gender))
			return false;
		if (customerlogin == null) {
			if (other.customerlogin != null)
				return false;
		} else if (!customerlogin.equals(other.customerlogin))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (loginid != other.loginid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customerdetails [id=" + id + ", name=" + name + ", email=" + email + ", Address=" + Address
				+ ", Gender=" + Gender + ", loginid=" + loginid + ", customerlogin=" + customerlogin + "]";
	}
	
	
	
}
