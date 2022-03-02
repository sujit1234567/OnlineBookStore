package com.book.dao;

import java.util.List;

import com.book.pojo.Customer;

public interface CustomerDao {

	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(int cid);
	
	Customer searchCustomer(int cid);
	Customer searchCustomer(String cemail);
	List<Customer> showCustomer();
}
