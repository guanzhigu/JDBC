package com.wst.test;
import java.sql.*;
public class testDML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String sql = "insert into test values(2,'GAME')";
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt=null;
				}
				if (conn != null) {
					conn.close();
					conn=null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
