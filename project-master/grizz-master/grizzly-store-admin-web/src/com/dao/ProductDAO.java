package com.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;

public interface ProductDAO {

	List<Product> listProduct() throws SQLException;
	public boolean productAdd(String name,String discription,String category,float price) throws SQLException;
	
}
