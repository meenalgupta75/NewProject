package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.connection.ConnectionManager;
import com.model.Login;
import com.model.Product;

public class LoginDAOImpl implements LoginDAO{
	ConnectionManager c1;
	Connection con;
	public LoginDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void showLoginForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		//c1=new ConnectionManager();
		//Connection con=c1.connect();
	    //int count=(Integer)request.getAttribute("count");
		//System.out.println(count);
		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}

	@Override
	public boolean validateUser(String username, String password) throws SQLException {
		String sql="select username,pasword from vendor where username=? and pasword=?";
		// TODO Auto-generated method stub
		//System.out.println("Hit It");
		//String sql2="select id,username,designation, office where username=? and pasword=?";
		c1=new ConnectionManager();
		Connection con=c1.connect();
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1,username);
		statement.setString(2,password);
		ResultSet rs=statement.executeQuery();
		boolean row;
		if(rs.next()){
			/*PreparedStatement statement2=con.prepareStatement(sql2);
			statement2.setString(1,username);
			statement2.setString(2,password);*/
			
			row=true;
		}
		else{
			row=false;
		}
		
		statement.close();
		c1.disconnect();
		return row;
	}

	@Override
	public void statusUpdate(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		int count=(int)(request.getAttribute("count"));
		System.out.println("in login dao Impl"+count);
		String sql = "insert into vendor (status) values(?) where username=?";
		
	}

	@Override
	public Login userDetails(String username) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select id,name,designation, office from vendor where username=?";
		c1=new ConnectionManager();
		Connection con=c1.connect();
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1,username);
		ResultSet rs=statement.executeQuery();
		rs.next();
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String designation=rs.getString("designation");
			String location =rs.getString("office");
			
			Login user= new Login(id,name,designation,location);
		
		return user;
	}
	public int setUserStatus(String username) throws SQLException
	{
		int currentStatus = getUserStatus(username);
		currentStatus=currentStatus+1;
		PreparedStatement preparedStatement = null;
		int status=0;
		c1=new ConnectionManager();
		Connection con=c1.connect();
		String insertStatement ="update vendor set status = ? where username = ?";
		
		try {
			preparedStatement = con.prepareStatement(insertStatement);
	
			preparedStatement.setInt(1, currentStatus);
			preparedStatement.setString(2, username);
	
			status = preparedStatement.executeUpdate();
			if(status==1)
			{
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		  c1.disconnect();
		}
		return -1;
		
	}
	public int getUserStatus(String id) throws SQLException {
		PreparedStatement preparedStatement = null;
		int status=0;
		c1=new ConnectionManager();
		Connection con=c1.connect();
		String insertStatement ="select status from vendor where username = ?";
		
		try {
			con.setAutoCommit(true);
			preparedStatement = con.prepareStatement(insertStatement);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
			 status = resultSet.getInt("status");
				return status;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			c1.disconnect();
		}
		return -1;
	}
	public int resetUserStatus(String username) throws SQLException{
		
		
		PreparedStatement preparedStatement = null;
		int status=0;
		c1=new ConnectionManager();
		Connection con=c1.connect();
		String insertStatement ="update vendor set status = ? where username = ?";
		
		try {
			con.setAutoCommit(true);
			preparedStatement = con.prepareStatement(insertStatement);
	
			preparedStatement.setInt(1,status);
			preparedStatement.setString(2,username);
	
			status = preparedStatement.executeUpdate();
			if(status==1)
			{
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			c1.disconnect();
		}
		return -1;
	}
	
	

}
