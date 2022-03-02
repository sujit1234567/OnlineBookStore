package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.util.DBConnectivity;

public class LoginDaoImpl implements LoginDao{

	Connection con=null;
	PreparedStatement ps;
	String sql;
	ResultSet rs;
	
	@Override
	public boolean isOurCustomer(String cemail, String password) {
		// TODO Auto-generated method stub
		
		con=DBConnectivity.getConnection();
		sql="select*from customer012174 where cemail=? and password=?";
		
		try {
			ps=con.prepareStatement(sql);
		    
			ps.setString(1, cemail);
			ps.setString(2, password);
		
			rs=ps.executeQuery();
			
			 if(rs.next()) {
				 
				 return true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean isOurAdmin(String adEmail, String adPassword) {
		con=DBConnectivity.getConnection();
		sql="select*from admin012174 where adEmail=? and adPassword=?";
		
		try {
			ps=con.prepareStatement(sql);
		    
			ps.setString(1, adEmail);
			ps.setString(2, adPassword);
		
			rs=ps.executeQuery();
			
			 if(rs.next()) {
				 
				 return true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
