package com.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProductService {
	public void getproduct(HttpServletRequest request,HttpServletResponse response) throws SQLException;

}
