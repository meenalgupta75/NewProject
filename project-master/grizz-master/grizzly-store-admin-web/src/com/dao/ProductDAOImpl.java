package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionManager;

import com.model.Product;

public class ProductDAOImpl  implements ProductDAO {
	  ConnectionManager c1;
	  public Connection con;

	@Override

	public java.util.List<com.model.Product> listProduct() throws SQLException {
		// TODO Auto-generated method stub
		c1=new ConnectionManager();
		java.util.List<com.model.Product> listProduct=new ArrayList<>();
	
		String sql="SELECT* FROM product ";
		c1=new ConnectionManager();
		Connection con=c1.connect();
		Statement statement =con.createStatement();
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()){
			int id=resultSet.getInt("id");
			String name=resultSet.getString("name");
			String discription=resultSet.getString("discription");
			String category=resultSet.getString("category");
			float price=resultSet.getFloat("price");
			Product prod=new Product(id,name,discription,category,price);
			listProduct.add(prod);	
		}
		return listProduct;
	}
	public boolean productAdd(String name,String discription,String category,float price) throws SQLException
	
	{
		c1=new ConnectionManager();
		Connection con=c1.connect();
		String sql1="select* from product where name='"+name+"' and category='"+category+"'";
			
		
		Statement ps2 =con.createStatement();
		//ps2.setString(1, name);
		//ps2.setString(2, category);
		
		ResultSet result=ps2.executeQuery(sql1);

	  
		
		if(result.next()==true)
		{
			System.out.print("not allowed");
			return false;
		}
		else
		{
		
		String sql="insert into product"+"(name,discription,category,price) values"+"(?,?,?,?)";
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1, name);
		p.setString(2, category);
		p.setString(3, discription);
		p.setFloat(4, price);
		int rs=p.executeUpdate();
		if(rs==1)
		{
			return true;
			
		}
		
		else{	
		
		return false;
		}
		
		}
		
	
	}
	public boolean delete(int id) throws SQLException
	{
		c1=new ConnectionManager();
		Connection con=c1.connect();
		String sql="delete from product where id=? ";
		PreparedStatement p=con.prepareStatement(sql);
		p.setInt(1, id);
	
		int rs=p.executeUpdate();
		if(rs==1)
		{
			return true;
			
		}
		else{
			
		
		return false;
		}
	}
	public Product view(int id) throws SQLException {
		// TODO Auto-generated method stub
	
	  Product prod=null;
		String sql="SELECT* FROM product where id=? ";
		c1=new ConnectionManager();
		Connection con=c1.connect();
		PreparedStatement rs =con.prepareStatement(sql);
		rs.setInt(1, id);
		ResultSet r=rs.executeQuery();
		
		
		while( r.next()){
			int d=r.getInt("id");
			String name=r.getString("name");
			String discription=r.getString("discription");
			String category=r.getString("category");
			float price=r.getFloat("price");
			prod =new Product(d,name,discription,category,price);
			
		}
		return prod;
		
	  
	}
	
	
}

