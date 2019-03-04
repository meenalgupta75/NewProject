package com.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Login;

public interface LoginDAO {
	void showLoginForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException;
	public boolean validateUser(String username,String password) throws SQLException;
	public void statusUpdate(HttpServletRequest request,HttpServletResponse response);
	public Login userDetails(String username) throws SQLException;
	public int setUserStatus(String id) throws SQLException;
	public int getUserStatus(String id) throws SQLException;
	public int resetUserStatus(String username) throws SQLException;

}
