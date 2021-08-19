package com.app.model;

public class Product {
	private String proName;
	private int numofItems;
	private float proPrice;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String proName, int numofItems, float proPrice) {
		super();
		this.proName = proName;
		this.numofItems = numofItems;
		this.proPrice = proPrice;
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
	public float getProPrice() {
		return proPrice;
	}
	public void setProPrice(float proPrice) {
		this.proPrice = proPrice;
	}

	@Override
	public String toString() {
		return "Product [proName=" + proName + ", numofItems=" + numofItems + ", proPrice="
				+ proPrice + "]";
	}
	
	

}
