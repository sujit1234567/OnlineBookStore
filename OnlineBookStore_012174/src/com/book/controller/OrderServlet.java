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

import com.book.dao.OrderDaoImpl;
import com.book.pojo.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    HttpSession session;
    RequestDispatcher rd;
    OrderDaoImpl oimpl=new OrderDaoImpl();
    Order o;
    //String cemail;
     int orderId;
	 String orderStatus;
	 String orderDate;
	 String cemail;
	 double totalBill;
     List<Order> olist;
    boolean flag;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		session=request.getSession(); 
		if(process!=null && process.equals("allOrders")) {
			 
			 olist=oimpl.showAllOrders();
			 session.setAttribute("allO", olist);
			 
			 response.sendRedirect("AllOrders.jsp");
		 }
		
		else if(process!=null && process.equals("updateStatus")) {
			
			orderId=Integer.parseInt(request.getParameter("orderId"));
			
			orderStatus="Completed";
			
			flag=oimpl.updateStatus(orderStatus, orderId);
			
			if(flag) {
				
				request.setAttribute("msg", "Status changed to completed");
				 olist=oimpl.showAllOrders();
				 session.setAttribute("allO", olist);
				
				rd=request.getRequestDispatcher("AllOrders.jsp");
			    rd.forward(request, response);
			    
			}
		}
		 else if(process!=null && process.equals("cancelOrder")) {
			

			orderId=Integer.parseInt(request.getParameter("orderId"));
			
			orderStatus="Cancelled";
			
			flag=oimpl.updateStatus(orderStatus, orderId);
			
			if(flag) {
				
				request.setAttribute("msg", "Status changed to cancelled!!!!!!");
				 olist=oimpl.showAllOrders();
				 session.setAttribute("allO", olist);
				
				rd=request.getRequestDispatcher("AllOrders.jsp");
			    rd.forward(request, response);
			    
			}

		}
		 else if(process!=null && process.equals("myOrderHistory")) {
			 
			 cemail=(String)session.getAttribute("customer");
			  olist=oimpl.showMyOrderHistory(cemail);
			  
			  if(olist.isEmpty()) {
				  
				  request.setAttribute("msg", "You have never ordered anything from our site yet");
				  rd=request.getRequestDispatcher("home.jsp");
				  rd.forward(request, response);
			  }
			  else {
				  
				  session.setAttribute("myOH", olist);
				  response.sendRedirect("MyOrderHist.jsp");
			  }
			  
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
	    session=request.getSession();
	    
		if(process!=null && process.equals("placeOrder")) {
	        
			cemail=(String)session.getAttribute("customer");
			
			totalBill=Double.parseDouble(request.getParameter("bill"));
			
			o=oimpl.placeOrder(cemail,totalBill);
			
			session.setAttribute("myOrder", o);
			
			request.setAttribute("msg", "Your order has been placed successfully");
			
			rd=request.getRequestDispatcher("MyOrder.jsp");
			rd.forward(request, response);
		}
	}

}
