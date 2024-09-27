package com.rakesh.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BatchProcessing {
	public static void main(String[] args) {
		Connection con = null;
	//	Statement stmt = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		
			// Batch Processing using Statement
//			stmt = con.createStatement();
//			stmt.addBatch("insert into user (id,name,age,address) values(103,'mukesh','18','pune')");
//			stmt.addBatch("insert into user (id,name,age,address) values(104,'ramesh','28','mumbai')");
//			stmt.addBatch("insert into user (id,name,age,address) values(105,'rohit','25','nasik')");
//			int[] count = stmt.executeBatch();
			
			// Batch Processing using PreparedStatement
			String query = "insert into user (id,name,age,address) values(?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1, 106);
			ps.setString(2, "shivam");
			ps.setString(3, "32");
			ps.setString(4, "Bhopal");
			ps.addBatch();
			
			ps.setInt(1, 107);
			ps.setString(2, "neeraj");
			ps.setString(3, "22");
			ps.setString(4, "Indore");
			ps.addBatch();
			
			ps.setInt(1, 108);
			ps.setString(2, "amit");
			ps.setString(3, "37");
			ps.setString(4, "Sagar");
			ps.addBatch();
			
			int[] count = ps.executeBatch();
			
			System.out.println(count);
		} catch (Exception e) {
			System.out.println(e.getMessage()+" "+e.getCause());
		}

	}
}
