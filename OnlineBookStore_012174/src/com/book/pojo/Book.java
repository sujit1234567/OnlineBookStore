package com.book.pojo;

import java.io.InputStream;

public class Book {

	private int bookid;
	private String bookname;
	private String author;
	private double bookprice;
	private String publisher;
	private int noOfCopies;
	
	private String description;
	private double rating;
	private String category;
	private InputStream image;
	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(int bookid, String bookname, String author, double bookprice, String publisher, int noOfCopies,
			String description, double rating, String category, InputStream image) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = author;
		this.bookprice = bookprice;
		this.publisher = publisher;
		this.noOfCopies = noOfCopies;
		this.description = description;
		this.rating = rating;
		this.category = category;
		this.image = image;
	}


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public InputStream getImage() {
		return image;
	}



	public void setImage(InputStream image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", author=" + author + ", bookprice=" + bookprice
				+ ", publisher=" + publisher + ", noOfCopies=" + noOfCopies + "]";
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getBookprice() {
		return bookprice;
	}

	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
	
	
}
