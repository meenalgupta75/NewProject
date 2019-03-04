package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionManager;

public class LoginDAOImpl implements LoginDAO{
	
  ConnectionManager c1;
	@Override
	public void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}

	@Override
	public boolean validateUser(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		c1=new ConnectionManager();
		System.out.print("validateuser"+username+password);
		String sql="SELECT username,password FROM user WHERE username=? and password=?";
		Connection jdbcConnection=c1.connect();
		System.out.println("jdbcConnection in validateuser"+jdbcConnection);
		
		PreparedStatement statement=jdbcConnection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2,password);
		ResultSet rs=statement.executeQuery();
		Boolean row;
		if(rs.next())
		{
			
			row=true;
			
			
			
		}
		else
		{
			row=false;
			
		}
		statement.close();
		c1.disconnect();
		
		return row;
	}

	
	

}
