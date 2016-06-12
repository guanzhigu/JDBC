package com.wst.test;

import java.sql.*;

public class testPrepStmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
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
			String sql = "insert into test values (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			System.out.println(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					ps = null;
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
