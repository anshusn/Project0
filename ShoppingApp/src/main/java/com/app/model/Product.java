package com.app.model;

public class Product {
	private int proId;
	private String proName;
	private int numofItems;
	private int proPrice;
	private int proDiscount;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int proId, String proName, int numofItems, int proPrice, int proDiscount) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.numofItems = numofItems;
		this.proPrice = proPrice;
		this.proDiscount = proDiscount;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getNumofItems() {
		return numofItems;
	}
	public void setNumofItems(int numofItems) {
		this.numofItems = numofItems;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getProDiscount() {
		return proDiscount;
	}
	public void setProDiscount(int proDiscount) {
		this.proDiscount = proDiscount;
	}
	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", numofItems=" + numofItems + ", proPrice="
				+ proPrice + ", proDiscount=" + proDiscount + "]";
	}
	
	

}
