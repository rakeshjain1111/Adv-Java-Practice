package com.rakesh.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateResultSet {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		String dburl = "jdbc:mysql://localhost:3306/mydb";
		String username = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, username, password);
//			String query = "Insert into user (id,name,age,address) value (?,?,?,?)";
//			ps = conn.prepareStatement(query);
//			ps.setInt(1, 102);
//			ps.setString(2, "Ram");
//			ps.setString(3, "24");
//			ps.setString(4, "Mumbai");

//			String query = "UPDATE user SET name=? WHERE id=?";
//			ps= conn.prepareStatement(query);
//			ps.setString(1, "Ramkumar");
//			ps.setInt(2,103);
			
//			String query = "DELETE FROM user WHERE id = ?";
//			ps = conn.prepareStatement(query);
//			ps.setInt(1, 103);
//			
//			int i = ps.executeUpdate();
//			System.out.println(i);
			
	         stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.FETCH_REVERSE);
			ResultSet rs = stmt.executeQuery("Select * from user");
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("age")+" "+rs.getString("address"));
			}
	} catch (Exception e) {
            System.out.println(e.getMessage()+" "+e.getCause());
		}
	}
}
