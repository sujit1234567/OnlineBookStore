package com.book.dao;

import java.util.List;

import com.book.pojo.Cart;

public interface CartDao {

	public boolean addToCart(Cart c);
	public boolean removeFromCart(int cartId);
	public boolean clearCart(String cemail);
	public boolean updateQuantity(int cartId, int quantity);
	public List<Cart> showMyCart(String cemail);
	public Cart checkBookId(int bookid, String cemail);
	
	
}
