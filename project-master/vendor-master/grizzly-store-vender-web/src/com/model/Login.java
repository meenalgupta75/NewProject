package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionManager;

public class Login {
 private String username;
 private String password;
 private int id;
 private String name;
 private String desgination;
 private String office;
public Login(int id, String name, String desgination, String office) {
	
	this.id = id;
	this.name = name;
	this.desgination = desgination;
	this.office = office;
}
public Login(String username, String password, int id, String name, String desgination, String office) {
	
	this.username = username;
	this.password = password;
	this.id = id;
	this.name = name;
	this.desgination = desgination;
	this.office = office;
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
public String getDesgination() {
	return desgination;
}
public void setDesgination(String desgination) {
	this.desgination = desgination;
}
public String getOffice() {
	return office;
}
public void setOffice(String office) {
	this.office = office;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Login(String username, String password) {
	
	this.username = username;
	this.password = password;
}
public Login() {
	
}

}
 

