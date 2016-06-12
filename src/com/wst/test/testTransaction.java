package com.wst.test;

import java.sql.*;

public class testTransaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "root");
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.addBatch("insert into test values(51,'500')");
			st.addBatch("insert into test values(52,'677')");
			st.addBatch("insert into test values(53,'644')");
			st.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (conn != null) {
					conn.rollback();
					conn.setAutoCommit(true);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
