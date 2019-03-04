package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDAO;
import com.dao.LoginDAOImpl;
import com.dao.ProductDAO;
import com.dao.ProductDAOImpl;
import com.model.Login;
import com.model.Product;

public class ProductServiceImpl implements ProductService{
	ProductDAO productDao;
	public ProductServiceImpl() {
	 productDao=new ProductDAOImpl();
	
	}
	@Override
	public void getAllproducts(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		List<Product> product=new ArrayList<>();
		product=productDao.listProduct();
		
		
		RequestDispatcher rs=request.getRequestDispatcher("Product.jsp");
		request.setAttribute("product", product);
	
		
		try {
			rs.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void addnewProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String category=request.getParameter("category");
		String description=request.getParameter("description");
		String name=request.getParameter("name");
		float price=Float.parseFloat(request.getParameter("price"));
		
		boolean rs=productDao.productAdd(category, name, description, price);
		if(rs){
			//System.out.println("in Product Service");
			List<Product> product=new ArrayList<>();
			product=productDao.listProduct();
			RequestDispatcher rs1 =request.getRequestDispatcher("Product.jsp");
			request.setAttribute("product", product);
			rs1.forward(request,response);
			}
		else{
			List<Product> product=new ArrayList<>();
			product=productDao.listProduct();
			RequestDispatcher rs1 =request.getRequestDispatcher("Product.jsp");
			request.setAttribute("product", product);
			rs1.forward(request,response);	
		}
		
		
	}
	@Override
	public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("product_id"));
		boolean rs=productDao.productDelete(id);
		if(rs){
			List<Product> product=new ArrayList<>();
			product=productDao.listProduct();
			RequestDispatcher rs1 =request.getRequestDispatcher("Product.jsp");
			request.setAttribute("product", product);
			rs1.forward(request,response);
		}
		
	}
	@Override
	public void viewProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, NumberFormatException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("product_id"));
		Product product=productDao.getview(id);
		RequestDispatcher rs=request.getRequestDispatcher("View.jsp");
		request.setAttribute("viewproduct", product);
		rs.forward(request, response);
		
	}
	
	
	
	


	

}
