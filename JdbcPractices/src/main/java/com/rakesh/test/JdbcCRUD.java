package com.rakesh.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCRUD {
	
	
	
	
	public static void main(String[] args) throws SQLException {
			Connection con =null;
			Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			stmt = con.createStatement();
			con.setAutoCommit(false);
			// String query ="CREATE DATABASE MYDB";
			// String query = "CREATE TABLE USER(id INT,name VARCHAR(50),age INT, address
			// VARCHAR(150))";
			//String query = "insert into user (id,name,age,address) values(102,'rajesh','28','pune')";
			//String query = "update user set name = 'rajesh' where id = 101";
			// String query ="delete from user where id = 101";
			//int i = stmt.executeUpdate(query);

			//System.out.println(i);
			
			ResultSet rs = stmt.executeQuery("Select * from user");
			while(rs.next()) {
				System.out.print(rs.getInt("id"));
				System.out.print(rs.getString("name"));
				System.out.print(rs.getString("age"));
				System.out.println(rs.getString("address"));
			}
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			stmt.close();
			con.close();
		}
	}
}
