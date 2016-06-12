package com.wst.test;

import java.sql.*;

public class testDML2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		int id =0;
		
		if (args.length != 2) {
			System.out.println("Parameter Error! Please Input Again!");
			System.exit(-1);
		}
		
		try {
	       id = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("Parameter Errotr! Id should be Number Format!");
			System.exit(-1);
		}
		
		String name =args[1];
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String sql = "insert into test values ("+id+",'"+name+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
