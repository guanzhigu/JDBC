package com.wst.test;
import java.sql.*;
public class testBatch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
  Class.forName("com.mysql.jdbc.Driver");
  String url="jdbc:mysql://localhost:3306/test";
  String username="root";
  String password="root";
  Connection conn = DriverManager.getConnection(url,username,password);
 /*
  Statement st = conn.createStatement();
  st.addBatch("insert into test values (51,'ge')");
  st.addBatch("insert into test values (52,'re')");
  st.addBatch("insert into test values (53,'fd')");
  st.executeBatch();
  st.close();
  */
  PreparedStatement ps = conn.prepareStatement("insert into test values(?,?)");
  ps.setInt(1, 61);
  ps.setString(2, "sb");
  ps.addBatch();
  
  ps.setInt(1, 62);
  ps.setString(2, "bitch");
  ps.addBatch();
   
  ps.setInt(1, 63);
  ps.setString(2, "penice");
  ps.addBatch();
  
  ps.executeBatch();
  ps.close();
  
  conn.close();
	}

}
