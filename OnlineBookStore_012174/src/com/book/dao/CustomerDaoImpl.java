package com.book.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.book.pojo.Customer;
import com.book.util.DBConnectivity;

public class CustomerDaoImpl implements CustomerDao{

	Customer c;
	Connection con=null;
	String sql;
	ResultSet rs;
	PreparedStatement ps;
	List<Customer> blist;
	@Override
	public boolean addCustomer(Customer c) {

		con=DBConnectivity.getConnection();
		
		sql="insert into customer012174(fname,lname,caddress,cemail,contact,password) values(?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getFname());
			ps.setString(2, c.getLname());
			ps.setString(3, c.getCaddress());
			ps.setString(4, c.getCemail());
			ps.setString(5, c.getContact());
			ps.setString(6, c.getPassword());
			
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
	public boolean updateCustomer(Customer c) {

		con=DBConnectivity.getConnection();
		sql="update customer012174 set fname=?, lname=?, caddress=?, cemail=?, contact=?, password=? where cid=?";
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getFname());
			ps.setString(2, c.getLname());
			ps.setString(3, c.getCaddress());
			ps.setString(4, c.getCemail());
			ps.setString(5, c.getContact());
			ps.setString(6, c.getPassword());
			ps.setInt(7, c.getCid());
			
			int i=ps.executeUpdate();
			
			System.out.println("in updatecustomer= "+ps);
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
	public boolean deleteCustomer(int cid) {

		con=DBConnectivity.getConnection();
		sql="delete from customer012174 where cid=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, cid);
			
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
	public Customer searchCustomer(int cid) {
		
		
				con=DBConnectivity.getConnection();
				sql="select * from customer012174 where cid=?";
				
				try {
					ps=con.prepareStatement(sql);
					ps.setInt(1, cid);
					rs=ps.executeQuery();
					

					while(rs.next())
					{
						c=new Customer();
						
						c.setCid(rs.getInt(1));
						c.setFname(rs.getString(2));
						c.setLname(rs.getString(3));
						c.setCaddress(rs.getString(4));
						c.setCemail(rs.getString(5));
						c.setContact(rs.getString(6));
						c.setPassword(rs.getString(7));
						return c;
					}
					
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

		return null;
	}

	@Override
	public Customer searchCustomer(String cemail) {
		

		con=DBConnectivity.getConnection();
		sql="select * from customer012174 where cemail=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, cemail);
			
			rs=ps.executeQuery();
			
			
             
			while(rs.next())
			{
				c=new Customer();
				
				c.setCid(rs.getInt(1));
				c.setFname(rs.getString(2));
				c.setLname(rs.getString(3));
				c.setCaddress(rs.getString(4));
				c.setCemail(rs.getString(5));
				c.setContact(rs.getString(6));
				c.setPassword(rs.getString(7));
				return c;
			}
			
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
		return null;
	}

	@Override
	public List<Customer> showCustomer() {

		con=DBConnectivity.getConnection();
		sql="select*from customer012174";
		
		try {
			ps=con.prepareStatement(sql);
			blist=new ArrayList<>();
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				c=new Customer();
				c.setCid(rs.getInt(1));
				c.setFname(rs.getString(2));
				c.setLname(rs.getString(3));
				c.setCaddress(rs.getString(4));
				c.setCemail(rs.getString(5));
				c.setContact(rs.getString(6));
				c.setPassword(rs.getString(7));
				
				blist.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	return blist;
	}

	public boolean updatepassword(String cemail) {
		
		con=DBConnectivity.getConnection();
		
		sql="update customer012174 set password=? where cemail=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getPassword());
			ps.setString(2, c.getCemail());
			
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
