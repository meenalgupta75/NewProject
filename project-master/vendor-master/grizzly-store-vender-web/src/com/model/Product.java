package com.model;

public class Product {
	private int product_id;
	private String category;
	private String product_name;
	private String description;
	private float price;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Product(int product_id, String category, String product_name, String description, float price) {
		
		this.product_id = product_id;
		this.category = category;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
	}
	public Product() {
		
	}
	

}
