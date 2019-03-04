package com.dao;

import java.sql.SQLException;
import java.util.List;


import com.model.Product;

public interface ProductDAO {
	List <Product> listProduct() throws SQLException;
	boolean productAdd(String category,String name,String description, float price) throws SQLException;
	boolean productDelete(int id) throws SQLException;
	Product getview(int id) throws SQLException;

	

}
