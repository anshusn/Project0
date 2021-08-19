package com.app.model;

public class Cart {
	private String product;
	private int countproduct;
	private int cusid;
	private float total;
	private Customerdetails customerdetail;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String product, int countproduct, int cusid, float total) {
		super();
		this.product = product;
		this.countproduct = countproduct;
		this.cusid = cusid;
		this.total = total;
	}
	
	
	
	public Customerdetails getCustomerdetail() {
		return customerdetail;
	}
	public void setCustomerdetail(Customerdetails customerdetail) {
		this.customerdetail = customerdetail;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getCountproduct() {
		return countproduct;
	}
	public void setCountproduct(int countproduct) {
		this.countproduct = countproduct;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + countproduct;
		result = prime * result + cusid;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + Float.floatToIntBits(total);
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
		Cart other = (Cart) obj;
		if (countproduct != other.countproduct)
			return false;
		if (cusid != other.cusid)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cart [product=" + product + ", countproduct=" + countproduct + ", cusid=" + cusid + ", total=" + total
				+ ", customerdetail=" + customerdetail + "]";
	}
	
	
	

}
