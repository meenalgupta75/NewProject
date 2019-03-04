package com.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDAO;
import com.dao.LoginDAOImpl;
import com.model.Login;

public class UserServiceImpl implements UserService{
	LoginDAO userDetails=new LoginDAOImpl();
	public UserServiceImpl() {
		userDetails=new LoginDAOImpl();
	}
	@Override
	public void getUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		LoginDAO userDetails=new LoginDAOImpl();
		String username=request.getParameter("username");
		Login user=new Login();
		user=userDetails.userDetails(username);
		RequestDispatcher rs=request.getRequestDispatcher("User.jsp");
		request.setAttribute("user", user);
		rs.forward(request, response);
		
	}

}
