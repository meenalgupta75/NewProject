package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionManager;
import com.model.Product;

public class ProductDAOImpl implements ProductDAO{
	ConnectionManager c1;

	@Override
	public List<Product> listProduct() throws SQLException {
		// TODO Auto-generated method stub
	// TODO Auto-generated method stub
			List<Product>  productlist=new ArrayList<>();
			String query="SELECT * FROM product";
			c1=new ConnectionManager();
			Connection con=c1.connect();
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery( query);
			while(rs.next()){
				int product_id=rs.getInt("product_id");
				String category=rs.getString("category");
				String product_name=rs.getString("product_name");
				String description =rs.getString("description");
				float price=rs.getFloat("price");
				Product product= new Product(product_id,category,product_name,description,price);
				productlist.add(product);
				
				}
			
				return productlist;
		}

	@Override
	public boolean productAdd(String category,String name,String description, float price) throws SQLException {
		// TODO Auto-generated method stub
		c1=new ConnectionManager();
		Connection con=c1.connect();
		String sql="insert into product"+
		"(category, product_name,description,price) values"+
				"(?,?,?,?)";
		String sql2="select * from product where category=? and product_name=?";
		PreparedStatement ps2=con.prepareStatement(sql2);
		ps2.setString(1,category);
		ps2.setString(2,name);
		ResultSet rs2=ps2.executeQuery();
		if(!(rs2.next()==false)){
			//code if product already exist
			System.out.println("Not allowerd");
			return false;
		}
		else{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,category);
		ps.setString(2,name);
		ps.setString(3,description);
		ps.setFloat(4,price);
		int rs=ps.executeUpdate();
		if(rs==1){
			return true;
		}
		}
		return false;
		
	}

	@Override
	public boolean productDelete(int id) throws SQLException {
		// TODO Auto-generated method stub
		c1=new ConnectionManager();
		Connection con=c1.connect();
		String sql="delete from product where product_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		int rs=ps.executeUpdate();
		if(rs==1){
			return true;
		}
		
		return false;
	}

	@Override
	public Product getview(int id) throws SQLException {
		// TODO Auto-generated method stub
		Product product=null;
		String sql="SELECT * FROM product where product_id=?";
		c1=new ConnectionManager();
		Connection con=c1.connect();
		PreparedStatement s=con.prepareStatement(sql);
		s.setInt(1,id);
		ResultSet rs=s.executeQuery();
		while(rs.next()){
			int product_id=rs.getInt("product_id");
			String category=rs.getString("category");
			String product_name=rs.getString("product_name");
			String description =rs.getString("description");
			float price=rs.getFloat("price");
			 product= new Product(product_id,category,product_name,description,price);
		}
			return product;

	}
	

	
}




