package com.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
	void getUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;

}
