package com.model;

public class Product {
private int id;
private String name;
private String category;
private String discription;
private float price;
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
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getDiscription() {
	return discription;
}
public void setDiscription(String discription) {
	this.discription = discription;
}
public float getPrice() {
	
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public Product(int id, String name, String category, String discription, float price) {
	super();
	this.id = id;
	this.name = name;
	this.category = category;
	this.discription = discription;
	this.price = price;
}
public Product() {
	super();
}

}
