package com.wst.test;
import java.sql.*;
public class testUpdataRs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
 Class.forName("com.mysql.jdbc.Driver");
 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from test");
		
		rs.next();
		rs.updateInt("id", 1);
		rs.updateString("name", "sb");
		rs.updateRow();
		
		rs.moveToCurrentRow();
		rs.updateInt(1, 999);
		rs.insertRow();
		rs.moveToCurrentRow();
		
		rs.absolute(5);
		rs.deleteRow();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
