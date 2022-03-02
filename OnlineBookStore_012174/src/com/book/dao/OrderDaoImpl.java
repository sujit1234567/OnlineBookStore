package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.book.pojo.Customer;
import com.book.pojo.Order;
import com.book.util.DBConnectivity;

public class OrderDaoImpl implements OrderDao{

    Order o;
	Connection con;
	String sql;
	ResultSet rs;
	PreparedStatement ps;
	List<Order> olist;
     CartDaoImpl cimpl=new CartDaoImpl();
     
	@Override
	public Order placeOrder(String cemail) {

		String orderStatus="processing...";
		
		Date today=new Date();
		String orderDate=today.toString();
		
		double totalBill=calculateBill(cemail);
		
        con=DBConnectivity.getConnection();		
		
        sql="insert into order012174(orderStatus,orderDate,cemail,totalBill) values(?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
		
		    ps.setString(1, orderStatus);
		    ps.setString(2, orderDate);
		    ps.setString(3, cemail);
		    ps.setDouble(4, totalBill);
		    
		    int i=  ps.executeUpdate();
		   
		    if(i>0)
		    {
		    	sql="select * from order012174 where cemail=? and orderDate=?";
		    	
		    	ps=con.prepareStatement(sql);
		    	
		    	ps.setString(1, cemail);
		    	ps.setString(2, orderDate);
		    	
		    	rs=ps.executeQuery();
		    	
		    	while(rs.next()) {
	                	    		
		    		o=new Order();
		    		o.setOrderId(rs.getInt(1));
		    		o.setOrderStatus(rs.getString(2));
		    		o.setOrderDate(rs.getString(3));
		    		o.setCemail(rs.getString(4));
		    		o.setTotalBill(rs.getDouble(5));
		    		
		    		return o;
		    	}
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				ps.close();
				con.close();
				//rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Order> showMyOrderHistory(String cemail) {

		con=DBConnectivity.getConnection();
		
		sql="select * from order012174 where cemail=?";
		
		try {
			ps=con.prepareStatement(sql);
			System.out.println(ps);
		     ps.setString(1, cemail);
		     
		     rs=ps.executeQuery();
		     
		     olist=new ArrayList<>();
		     
		     while(rs.next())
		     {
		    	 o=new Order();
		    	 o.setOrderId(rs.getInt(1));
		    	 o.setOrderStatus(rs.getString(2));
		    	 o.setOrderDate(rs.getString(3));
		    	 o.setCemail(rs.getString(4));
		    	 o.setTotalBill(rs.getDouble(5));
		    	 
		    	 olist.add(o);
		     }
		     return olist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally {
			
			try {
				ps.close();
				con.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Order> showAllOrders() {
          
		con=DBConnectivity.getConnection();
		
		sql="select * from order012174";
		
		try {
			ps=con.prepareStatement(sql);
		   	System.out.println(ps);
			
			rs=ps.executeQuery();
		     
		     olist=new ArrayList<>();
		     
		     while(rs.next())
		     {
		    	 o=new Order();
		    	 o.setOrderId(rs.getInt(1));
		    	 o.setOrderStatus(rs.getString(2));
		    	 o.setOrderDate(rs.getString(3));
		    	 o.setCemail(rs.getString(4));
		    	 o.setTotalBill(rs.getDouble(5));
		    	 
		    	 olist.add(o);
		     }
		        return olist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally {
			
			try {
				ps.close();
				con.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

    
	public double calculateBill(String cemail) {
		
		double totalBill=0;
		con=DBConnectivity.getConnection();
		sql="select sum(b.bookprice* c.quantity) from book012174 b inner join cart012174 c on (b.bookid=c.bookid) where c.cemail=?";
		
		try {
			ps=con.prepareStatement(sql);
		
		     ps.setString(1, cemail);
		     
		     rs=ps.executeQuery();
		     
		     if(rs.next())
		    	 totalBill=rs.getDouble(1);
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalBill;
	}
	
	public Order placeOrder(String cemail, double totalBill) {

		String orderStatus="processing...";
		
		Date today=new Date();
		String orderDate=today.toString();
		
		//double totalBill=calculateBill(cemail);
		
        con=DBConnectivity.getConnection();		
		
        sql="insert into order012174(orderStatus,orderDate,cemail,totalBill) values(?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
		
		    ps.setString(1, orderStatus);
		    ps.setString(2, orderDate);
		    ps.setString(3, cemail);
		    ps.setDouble(4, totalBill);
		    
		    int i=  ps.executeUpdate();
		   
		    if(i>0)
		    {
		    	
		    	cimpl.clearCart(cemail);
		    	
		    	sql="select * from order012174 where cemail=? and orderDate=?";
		    	
		    	ps=con.prepareStatement(sql);
		    	
		    	ps.setString(1, cemail);
		    	ps.setString(2, orderDate);
		    	
		    	rs=ps.executeQuery();
		    	
		    	while(rs.next()) {
	                	    		
		    		o=new Order();
		    		o.setOrderId(rs.getInt(1));
		    		o.setOrderStatus(rs.getString(2));
		    		o.setOrderDate(rs.getString(3));
		    		o.setCemail(rs.getString(4));
		    		o.setTotalBill(rs.getDouble(5));
		    		
		    		return o;
		    	}
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				ps.close();
				con.close();
				//rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return null;
}
	
	public boolean updateStatus(String orderStatus, int orderId) {
		
		con=DBConnectivity.getConnection();
		
		sql="update order012174 set orderStatus=? where orderId=? ";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, orderStatus);
			ps.setInt(2, orderId);
			
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
	
