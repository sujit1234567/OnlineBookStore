package com.book.pojo;

public class Order {

	private int orderId;
	private String orderStatus;
	private String orderDate;
	private String cemail;
	private double totalBill;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, String orderStatus, String orderDate, String cemail, double totalBill) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.cemail = cemail;
		this.totalBill = totalBill;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", cemail="
				+ cemail + ", totalBill=" + totalBill + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	
}
