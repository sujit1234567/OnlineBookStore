package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.pojo.Cart;
import com.book.pojo.Customer;
import com.book.util.DBConnectivity;

public class CartDaoImpl implements CartDao{

	Connection con;
	String sql;
	ResultSet rs;
	PreparedStatement ps;
	List<Customer> blist;
	Cart c;
	@Override
	public boolean addToCart(Cart c) {
		
		con=DBConnectivity.getConnection();
		
		sql="insert into cart012174(bookid, cemail, quantity) values (?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
		
		     ps.setInt(1, c.getBookid());
		     ps.setString(2, c.getCemail());
		     ps.setInt(3, c.getQuantity());
		     
		     int i=ps.executeUpdate();
		     
		     if(i>0)
		    	 return true;
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean removeFromCart(int cartId) {

		con=DBConnectivity.getConnection();
		sql="delete from cart012174 where cartId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, cartId);
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean clearCart(String cemail) {

		con=DBConnectivity.getConnection();
		sql="delete from cart012174 where cemail=?";
		
		try {
			ps=con.prepareStatement(sql);
		
		     ps.setString(1, cemail);
		     
		     int i=ps.executeUpdate();
		     
		     if(i>0)
		    	 return true;
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateQuantity(int cartId, int quantity) {

		con=DBConnectivity.getConnection();
		sql="update cart012174 set quantity=? where cartId=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, quantity);
			ps.setInt(2, cartId);
			
			//ps.setInt(2, c.getCartId());
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Cart> showMyCart(String cemail) {
		
		con=DBConnectivity.getConnection();
		
		sql=" select c.cartId, c.bookid, b.bookname, b.bookprice, c.cemail, c.quantity from cart012174 c inner join book012174 b on(c.bookid=b.bookid) where c.cemail=?;";
		
		try {
			ps=con.prepareStatement(sql);
		    
			ps.setString(1, cemail);
			
			rs=ps.executeQuery();
			
			List<Cart>clist=new ArrayList<>();
			
			while(rs.next())
			{
				c=new Cart();
				
				c.setCartId(rs.getInt(1));
				c.setBookid(rs.getInt(2));
				c.setBookname(rs.getString(3));
				c.setBookprice(rs.getDouble(4));
				c.setCemail(rs.getString(5));
				c.setQuantity(rs.getInt(6));
				
				clist.add(c);
			}
			return clist;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
public Cart checkBookId(int bookid, String cemail) {
	
	con=DBConnectivity.getConnection();
	sql="select*from cart012174 where bookid=? and cemail=?";
	try {
		ps=con.prepareStatement(sql);
		
		ps.setInt(1, bookid);
		ps.setString(2, cemail);
		
		rs=ps.executeQuery();
		
		if(rs.next()) {
			
			c=new Cart();
			
			c.setCartId(rs.getInt(1));
			c.setBookid(rs.getInt(2));
			c.setCemail(rs.getString(3));
			c.setQuantity(rs.getInt(4));
			
			return c;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

return null;
}

public List<Cart> showAllCartCopy(){
	

	con=DBConnectivity.getConnection();
	
	sql=" select c.cartId, c.bookid, b.bookname, b.bookprice, c.cemail, c.quantity from cartCopy012174 c inner join book012174 b on(c.bookid=b.bookid)";
	
	try {
		ps=con.prepareStatement(sql);
	    
		//ps.setString(1, cemail);
		
		rs=ps.executeQuery();
		
		List<Cart>clist=new ArrayList<>();
		
		while(rs.next())
		{
			c=new Cart();
			
			c.setCartId(rs.getInt(1));
			c.setBookid(rs.getInt(2));
			c.setBookname(rs.getString(3));
			c.setBookprice(rs.getDouble(4));
			c.setCemail(rs.getString(5));
			c.setQuantity(rs.getInt(6));
			
			clist.add(c);
		}
		return clist;
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return null;
}

  public Cart showCartById(int cartId) {
	  
	  con=DBConnectivity.getConnection();
	  
	  sql="select * from cartCopy012174 where cartId=?";
	  
	  try {
		ps=con.prepareStatement(sql);
		
		ps.setInt(1, cartId);
		
		rs=ps.executeQuery();
		
		while(rs.next()) {
			
			c=new Cart();
			c.setCartId(rs.getInt(1));
			c.setBookid(rs.getInt(2));
			c.setCemail(rs.getString(3));
			c.setQuantity(rs.getInt(4));
			
			return c;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return null;
  }
  
  public boolean deleteFromCartCopy(int cartId) {
	  
	  con=DBConnectivity.getConnection();
	  
	  sql="delete from cartCopy012174 where cartId=?";
	  
	  try {
		ps=con.prepareStatement(sql);
		
		ps.setInt(1, cartId);
		
		int i=ps.executeUpdate();
		
		if(i>0)
			return true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	   return false;
  }
}
