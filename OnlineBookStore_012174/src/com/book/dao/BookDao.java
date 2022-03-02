package com.book.dao;

import java.util.List;

import com.book.pojo.Book;

public interface BookDao {

	public boolean addBooks(Book b);
	public boolean updateBook(Book b);
	public boolean deleteBook(int bookid);
	
	public List<Book> showAllBooks();
	public List<Book> showBookByAuthor(String author);
	public List<Book> showBookByPublisher(String publisher);
	
	public Book showBookById(int bookid);
	
	
}
