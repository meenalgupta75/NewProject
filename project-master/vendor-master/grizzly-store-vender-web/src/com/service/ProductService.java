package com.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProductService {
	void getAllproducts(HttpServletRequest request, HttpServletResponse response) throws SQLException;
	void addnewProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
	void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
	void viewProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, NumberFormatException, ServletException, IOException;



}
