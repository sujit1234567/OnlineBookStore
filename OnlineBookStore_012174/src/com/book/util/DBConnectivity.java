package com.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectivity {

	public static Connection getConnection() {
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Properties pro=new Properties();
			pro.setProperty("user", "root");
			pro.setProperty("password", "root");
			pro.setProperty("useSSL", "false");
			pro.setProperty("allowPublicKeyRetrieval", "true");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ct30_sip012174",pro);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
