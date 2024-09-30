package com.rakesh.TestConnectionPool;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test_C3P0 {
	static  Connection conn = null;
	static  Statement stmt = null;
	static final String driver = "com.mysql.jdbc.Driver";
	static final String dburl = "jdbc:mysql://localhost:3306/mydb";
	static final String username = "root";
	static final String password = "root";
 
	public static void main(String[] args) {
	ComboPooledDataSource ds = new ComboPooledDataSource();
	
	try {
		//Set DS Properties
		ds.setDriverClass(driver);
		ds.setJdbcUrl(dburl);
		ds.setUser(username);
		ds.setPassword(password);
		
		//Minimum number of connections
		ds.setInitialPoolSize(5);
		//connection increment when more user
		ds.setAcquireIncrement(5);
		//Max number of Connection
		ds.setMaxPoolSize(50);
		
		conn = ds.getConnection();
		stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("Select * from user");
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("age")+" "+rs.getString("address"));
		}
		
		
	} catch (Exception e) {
		System.out.println(e.getMessage()+" "+e.getCause());
	}
}
}
