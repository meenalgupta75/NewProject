package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private Connection con;
	private String url="jdbc:mysql://localhost:3306/grizzlystore";
	private String username="root";
	private String password="root";
	
	
	public Connection connect() throws SQLException{
		if(con==null || con.isClosed())
		{
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e){
				throw new SQLException(e);
			}
			con=DriverManager.getConnection(url,username,password);
			
		}
		return con;
	}
	public void disconnect() throws SQLException{
		if(con!=null && !con.isClosed()){
			con.close();
		}
	
	}

}
