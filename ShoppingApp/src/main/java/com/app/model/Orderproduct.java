package com.app.model;

public class Orderproduct {
	private int orderid;
	private String productname;
	private int customerid;
	private Customerdetails customerdetails;
	
	
	public Customerdetails getCustomerdetails() {
		return customerdetails;
	}
	public void setCustomerdetails(Customerdetails customerdetails) {
		this.customerdetails = customerdetails;
	}
	public Orderproduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orderproduct(int orderid, String productname, int customerid) {
		super();
		this.orderid = orderid;
		this.productname = productname;
		this.customerid = customerid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerid;
		result = prime * result + orderid;
		result = prime * result + ((productname == null) ? 0 : productname.hashCode());
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
		Orderproduct other = (Orderproduct) obj;
		if (customerid != other.customerid)
			return false;
		if (orderid != other.orderid)
			return false;
		if (productname == null) {
			if (other.productname != null)
				return false;
		} else if (!productname.equals(other.productname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Orderproduct [orderid=" + orderid + ", productname=" + productname + ", customerid=" + customerid
				+ ", customerdetails=" + customerdetails + "]";
	}
	
}
