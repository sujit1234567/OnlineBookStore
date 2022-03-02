package com.book.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.Session;

import com.book.dao.BookDaoImpl;
import com.book.dao.CartDaoImpl;
import com.book.pojo.Book;
import com.book.pojo.Cart;

/**
 * Servlet implementation class BookServlet
 */
@MultipartConfig
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    HttpSession session;
    RequestDispatcher rd;
    BookDaoImpl bimpl=new BookDaoImpl();
    Book b;
    
    List<Book> blist;
    
     int bookid;
	 String bookname;
	 String author;
	 double bookprice;
	 String publisher;
	 int noOfCopies;
	
	 String description;
	 double rating;
	 String category;
	 InputStream image;
     boolean flag=true;
    
     CartDaoImpl cimpl=new CartDaoImpl();
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String process=request.getParameter("process");
	     
    	 session=request.getSession();
    	 
    	  if(process!=null && process.equals("updateBook")) {
    		  
    		  bookid=Integer.parseInt(request.getParameter("bookid"));
    		  
    		  b=bimpl.showBookById(bookid);
    		  
    		  session.setAttribute("uBook", b);
    		  
    		  response.sendRedirect("UpdateBook.jsp");
    	  }
    	  else if(process!=null && process.equals("deleteBook")) {
    		  
    		  bookid=Integer.parseInt(request.getParameter("bookid"));
    		  
    		  flag=bimpl.deleteBook(bookid);
    		  
    		  if(flag) {
    			   request.setAttribute("msg","Book deleted successfully");
    			   
    			   blist=bimpl.showAllBooks();
    			   session.setAttribute("blist", blist);
    			   
    			   rd=request.getRequestDispatcher("booklist.jsp");
    			   rd.forward(request,response);
    			   
    		  }
    		  else {
    			  request.setAttribute("emsg", "Error while deleting book");
    			  
    			  blist=bimpl.showAllBooks();
    			  session.setAttribute("blist",blist);
    			  
    			  rd=request.getRequestDispatcher("booklist.jsp");
   			      rd.forward(request,response);
   			  
    		  }
    	  }
    	  
    	  else if(process!=null && process.equals("getBooksByCategory")) {
    		  
    		  category=request.getParameter("category");
    		  
    		  blist=bimpl.showBooksByCategory(category);
    	     
    		  session.setAttribute("blist", blist);
    		  
    		  response.sendRedirect("home.jsp");
    	  }
    	   
          else if(process!=null && process.equals("getBooksByAuthor")) {
    		  
    		  author=request.getParameter("author");
    		  
    		  blist=bimpl.showBookByAuthor(author);
    	     
    		  session.setAttribute("blist", blist);
    		  
    		  response.sendRedirect("home.jsp");
    	  }
    	
          else if(process!=null && process.equals("viewBook")) {
        	  
        	bookid=Integer.parseInt(request.getParameter("bookid"));
        	
        	b=bimpl.showBookById(bookid);
        	
        	session.setAttribute("vBook", b);
        	
        	response.sendRedirect("ViewBook.jsp");
          }
    	  
          else if(process!=null && process.equals("updateCopies")) {
        	  
        	  int cartId=Integer.parseInt(request.getParameter("cartId"));
        	  
        	  
        	 Cart c=new CartDaoImpl().showCartById(cartId);
        	 b=bimpl.showBookById(c.getBookid());
        	 
        	 noOfCopies=b.getNoOfCopies();
        	 
        	 int quantity=c.getQuantity();
        	 
        	 b.setNoOfCopies(noOfCopies-quantity);
        	 
        	flag= bimpl.updateBook(b);
        	
        	if(flag) {
        		
        		request.setAttribute("msg", "Stock updated");
        		
        		cimpl.deleteFromCartCopy(cartId);
        		
        		List<Cart> cartList=cimpl.showAllCartCopy();
        		if(cartList.isEmpty()) {
        			
        			request.setAttribute("mag", "No data to display");
        			rd=request.getRequestDispatcher("home.jsp");
        			rd.forward(request, response);
        		}
        		else {
        		session.setAttribute("allCartCopy", cartList);
        		
        		rd=request.getRequestDispatcher("AllCart.jsp");
        		rd.forward(request, response);
        		}
        	}
        	else {
        		
        		request.setAttribute("emsg", "Erro while updating stock");
        		
        		rd=request.getRequestDispatcher("AllCart.jsp");
        		rd.forward(request, response);
        	}
          }
    	  
          else if(process!=null && process.equals("allBooks")){
        	  
    		  blist=bimpl.showAllBooks();
              
    		  session.setAttribute("blist", blist);
    		  
    		  response.sendRedirect("booklist.jsp");
          }
    	  else {
    		  
    		  blist=bimpl.showAllBooks();
    		  Set<String> categories=bimpl.categories();
    		  Set<String> authors=bimpl.authors();
   		  
     		  session.setAttribute("blist", blist);
    		  session.setAttribute("allCats", categories);
    		  session.setAttribute("allAuthors", authors);
                                      
    		  rd=request.getRequestDispatcher("home.jsp");
    		  rd.forward(request, response);
    	  }
    	  
     }
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		PrintWriter pw=response.getWriter();
		session =request.getSession();
		System.out.println("Process in doPost= "+process);
		 if(process!=null && process.equals("addBook")) 
		 {
			 //Getting all the information from page and saving in variables; 
			 bookname=request.getParameter("bookname");
			 author=request.getParameter("author");
			 bookprice=Double.parseDouble(request.getParameter("bookprice"));
			 publisher=request.getParameter("publisher");
			 noOfCopies=Integer.parseInt(request.getParameter("noOfCopies"));
			 description=request.getParameter("description");
			 rating=Double.parseDouble(request.getParameter("rating"));
			 category=request.getParameter("category");
			 
			 Part p=request.getPart("image");
			 image=p.getInputStream();

			 b=new Book();
			 //setting the values given by admin into our book object
			 
			 b.setAuthor(author);
			 b.setBookname(bookname);
			 b.setBookprice(bookprice);
			 b.setCategory(category);
			 b.setDescription(description);
			 b.setImage(image);
			 b.setNoOfCopies(noOfCopies);
			 b.setPublisher(publisher);
			 b.setRating(rating);
			 
			 flag=bimpl.addBooks(b);
			 
			 if(flag) {
				 
				 blist=bimpl.showAllBooks();
				 session.setAttribute("blist", blist);
				 
				 request.setAttribute("msg", "Book added successfully");
				 
				 rd=request.getRequestDispatcher("booklist.jsp");
				 rd.forward(request, response);
				 
			 }
			 else {
				 request.setAttribute("emsg", "Error while adding book");
				 rd=request.getRequestDispatcher("addBook.jsp");
				 rd.include(request, response);
			 }
		 }
		  
		 else if(process!=null && process.equals("update")) {
			 
			 bookid=Integer.parseInt(request.getParameter("bookid"));
			 bookname=request.getParameter("bookname");
			 author=request.getParameter("author");
			 bookprice=Double.parseDouble(request.getParameter("bookprice"));
			 publisher=request.getParameter("publisher");
			 noOfCopies=Integer.parseInt(request.getParameter("noOfCopies"));
			 description=request.getParameter("description");
			 rating=Double.parseDouble(request.getParameter("rating"));
			 category=request.getParameter("category");
			 
			 Part p=request.getPart("image");
			 image=p.getInputStream();

			 
			 b=bimpl.showBookById(bookid);
			  
			 b.setAuthor(author);
			 b.setBookname(bookname);
			 b.setBookprice(bookprice);
			 b.setCategory(category);
			 b.setDescription(description);
			 
			 if(image.available()!=0) {
			
				 b.setImage(image);
			 }
			 
			 b.setNoOfCopies(noOfCopies);
			 b.setPublisher(publisher);
			 b.setRating(rating);
			 
			flag= bimpl.updateBook(b);
			  
			if(flag) {
				 
				request.setAttribute("msg", "Book updated successfully");
				
				blist=bimpl.showAllBooks();
				
				session.setAttribute("blist", blist);
				
				rd=request.getRequestDispatcher("booklist.jsp");
				rd.forward(request, response);
			}
			else {
				
				request.setAttribute("emsg", "Error while updating book" );
				blist=bimpl.showAllBooks();
				session.setAttribute("blist", blist);
				rd=request.getRequestDispatcher("booklist.jsp");
				rd.forward(request, response);
				
			}
		 }
	}

}
