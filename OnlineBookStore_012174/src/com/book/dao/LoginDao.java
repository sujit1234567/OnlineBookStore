package com.book.dao;

public interface LoginDao {

	public boolean isOurCustomer(String cemail, String password);
	
	public boolean isOurAdmin(String adEmail, String adPassword);

}
