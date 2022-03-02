package com.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.CartDaoImpl;
import com.book.pojo.Cart;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    HttpSession session;
    RequestDispatcher rd;
    Cart c;
    CartDaoImpl cimpl=new CartDaoImpl();
    List<Cart> cartList;
    
     int cartId;
	 int bookid;
	 String cemail;
	 int quantity;
	 String bookname;
	 double bookprice;
	 boolean flag;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		session=request.getSession();
		cemail=(String)session.getAttribute("customer");
		
		if(process!=null && process.equals("addToCart")) {
			bookid=Integer.parseInt(request.getParameter("bookid"));
			
		if(cemail==null) {
			request.setAttribute("emsg", "Please login first before adding books to cart!!!");
		    rd=request.getRequestDispatcher("login.jsp");
		    rd.forward(request, response);
		   
		}
		else if(cemail!=null) {
			
			Cart c1=cimpl.checkBookId(bookid, cemail);
			
			if(c1!=null) {
				
				cartId=c1.getCartId();
				quantity=c1.getQuantity()+1;
				
				cimpl.updateQuantity(cartId, quantity);
				
				request.setAttribute("msg", "This product was already in cart, and the quantity has been increased!!");
				rd=request.getRequestDispatcher("home.jsp");
				rd.include(request, response);
				
			}
		
		else {
			
			quantity=1;
			
			c=new Cart();
			c.setBookid(bookid);
			c.setCemail(cemail);
			c.setQuantity(quantity);
			
			flag=cimpl.addToCart(c);
	        	
			if(flag) {
				request.setAttribute("msg", "Book added to cart successfully!!!");
				
				rd=request.getRequestDispatcher("home.jsp");
				rd.include(request, response);
			}
			else {
                request.setAttribute("emsg", "Error while adding book to cart!!!");
				rd=request.getRequestDispatcher("home.jsp");
				rd.include(request, response);
				
			}
			}
		}
		
		
		}
		else if(process!=null && process.equals("myCart")) {
		   
			cemail=(String)session.getAttribute("customer");
			
			cartList=cimpl.showMyCart(cemail);
			
			if(cartList.isEmpty()) {
				
				request.setAttribute("msg", "Please add books to your cart first");
				
				rd=request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
				
			}
			
			else {
				
				session.setAttribute("myCList", cartList);
			    rd=request.getRequestDispatcher("ViewCart.jsp");
			    rd.forward(request, response);
			
			}
		}
         else if(process!=null && process.equals("deleteCart")) {
			
        	 cartId=Integer.parseInt(request.getParameter("cartid"));
   		    
   		           flag=cimpl.removeFromCart(cartId);
   		  
   		  if(flag) {
   			   request.setAttribute("msg","Cart deleted successfully");
   			   
   			   cartList=cimpl.showMyCart(cemail);
   			   
   			   if(cartList.isEmpty()) {
   				   
   	   			   request.setAttribute("msg"," Your Cart has became empty ");

   	   			   rd=request.getRequestDispatcher("home.jsp");
   	   			   rd.forward(request, response);
   			   }
   			   session.setAttribute("Clist", cartList);
   			   
   			   rd=request.getRequestDispatcher("ViewCart.jsp");
   			   rd.forward(request,response);
   			   
   		  }
   		  else {
   			  request.setAttribute("emsg", "Error while deleting cart");
   			  
   			cartList=cimpl.showMyCart(cemail);
   			  session.setAttribute("Clist",cartList);
   			  
   			  rd=request.getRequestDispatcher("ViewCart.jsp");
   			  rd.forward(request,response);
   		  }
			
		}
         else if(process!=null && process.equals("allCart")) {
        	 
        	 cartList=cimpl.showAllCartCopy();
        	 
        	 session.setAttribute("allCartCopy", cartList);
        	 
        	 response.sendRedirect("AllCart.jsp");
        	 //rd=request.getRequestDispatcher("AllCart.jsp");
        	 //rd.forward(request, response);
         }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		session=request.getSession();
		
		if(process!=null && process.equals("updateQuantity")) {
			
			  quantity=Integer.parseInt(request.getParameter("Quantity"));
			  cartId=Integer.parseInt(request.getParameter("Cid"));
			  
			  cimpl.updateQuantity(cartId, quantity);
		}
	}

}
