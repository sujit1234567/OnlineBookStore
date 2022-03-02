package com.book.dao;

import java.util.List;

import com.book.pojo.Order;

public interface OrderDao {

	
	public Order placeOrder(String cemail);
	public List<Order> showMyOrderHistory(String cemail);
	public List<Order> showAllOrders();
	
}
