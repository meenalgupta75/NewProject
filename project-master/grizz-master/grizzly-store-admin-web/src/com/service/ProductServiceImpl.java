package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAOImpl;
import com.model.Product;

public class ProductServiceImpl implements ProductService{
	ProductDAOImpl pl;
	public ProductServiceImpl()
	{
		pl=new ProductDAOImpl();
	}
	public void getproduct(HttpServletRequest request,HttpServletResponse response) throws SQLException
	{
		List<Product> product=new ArrayList<>();
		product=pl.listProduct();
		int i=0;
		RequestDispatcher rs=request.getRequestDispatcher("Product.jsp");
		request.setAttribute("product", product);
		try{
			
			rs.forward(request, response);
		}catch(ServletException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public void Addnewproduct(HttpServletRequest request,HttpServletResponse response)throws ServletException, SQLException, IOException
	{
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		String discription=request.getParameter("discription");
		float price=Float.parseFloat(request.getParameter("price"));
		boolean rs=pl.productAdd(name, discription, category, price);
		if(rs){
			List<Product>product=new ArrayList<>();
			product=pl.listProduct();
			RequestDispatcher rs1=request.getRequestDispatcher("Product.jsp");
			request.setAttribute("product", product);
			rs1.forward(request,response);
			
			
		}
	}
		
	
	public void deleteproduct(HttpServletRequest request,HttpServletResponse response) throws ServletException,SQLException,IOException
	{
	  int id=Integer.parseInt(request.getParameter("id"));
		boolean rs=pl.delete( id);
		if(rs){
			List<Product>product=new ArrayList<>();
			product=pl.listProduct();
			RequestDispatcher rs2=request.getRequestDispatcher("Product.jsp");
			request.setAttribute("product", product);
			rs2.forward(request, response);
	}
	}
	public void viewproduct(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		int id=Integer.parseInt(request.getParameter("id"));
		Product rs=pl.view( id);
		RequestDispatcher rs2=request.getRequestDispatcher("view.jsp");
		request.setAttribute("view", rs);
		rs2.forward(request, response);
		
	}
	
}

