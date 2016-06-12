package com.wst.test;

import java.sql.*;

public class testScroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "root");
     Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
     ResultSet rs = st.executeQuery("select * from test order by id");
     rs.next();
     System.out.println(rs.getInt(1));
     rs.last();
     System.out.println(rs.getString(1));
     System.out.println(rs.isLast());
     System.out.println(rs.isAfterLast());
     System.out.println(rs.getRow());
     rs.previous();
     System.out.println(rs.getString(1));
     rs.absolute(6);
     System.out.println(rs.getString(1));
     rs.close();
     conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
