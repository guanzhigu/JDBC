package com.wst.test;

import java.sql.*;

public class testPrec {

	public static void main(String[] args) throws Exception {
		  CallableStatement cs = null;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String password = "root";
			Connection conn = DriverManager.getConnection(url, username, password);
						
			cs = conn.prepareCall("call p(?,?,?,?)");
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.setInt(1, 3);
			cs.setInt(2, 4);
			cs.setInt(4, 5);
			cs.execute();
			System.out.println(cs.getInt(3));
			
	}
	}
