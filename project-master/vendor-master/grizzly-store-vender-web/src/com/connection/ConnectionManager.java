package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	String url;
	String username;
	String password;
	String driver;
	Connection con;
	public ConnectionManager() {
		url="jdbc:mysql://localhost:3306/grizzlystore?useSSL=false";
		username="root";
		password="root";
		driver="com.mysql.jdbc.Driver";
	}
	
	public Connection connect() throws SQLException{
		
		if(con==null||con.isClosed()){
			try{
				Class.forName(driver);
				
			}catch(ClassNotFoundException e){
				throw new  SQLException(e);
			}
			con=DriverManager.getConnection(url,username,password);
			
			}
		return con;
		
	}
	public void disconnect() throws SQLException {
		if(con!=null && !con.isClosed()){
			con.close();
		}
	}

}
