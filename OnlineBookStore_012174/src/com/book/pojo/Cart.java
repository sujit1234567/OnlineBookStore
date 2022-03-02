package com.book.pojo;

public class Cart {

	private int cartId;
	private int bookid;
	private String cemail;
	private int quantity;
	private String bookname;
	private double bookprice;
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	
	public Cart(int cartId, int bookid, String cemail, int quantity, String bookname, double bookprice) {
		super();
		this.cartId = cartId;
		this.bookid = bookid;
		this.cemail = cemail;
		this.quantity = quantity;
		this.bookname = bookname;
		this.bookprice = bookprice;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookid=" + bookid + ", cemail=" + cemail + ", quantity=" + quantity
				+ ", bookname=" + bookname + ", bookprice=" + bookprice + "]";
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
