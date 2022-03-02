package com.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.BookDaoImpl;
import com.book.dao.CustomerDaoImpl;
import com.book.pojo.Book;
import com.book.pojo.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    HttpSession session;
    RequestDispatcher rd;
    CustomerDaoImpl cimpl=new CustomerDaoImpl();
    Customer c;
    
    List<Customer> clist;
   
     int cid;
	 String fname;
	 String lname;
	 String caddress;
	 String cemail;
	 String contact;
	 String password;
	 boolean flag;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
	     
   	    session=request.getSession();
   	    
   	 if(process!=null && process.equals("updateCustomer")) {
		  
		  cid=Integer.parseInt(request.getParameter("cid"));
		  
		  c=cimpl.searchCustomer(cid);
		  
		  session.setAttribute("uCust", c);
		  
		  response.sendRedirect("UpdateCustomer.jsp");
	  }
   	 
   	 else if(process!=null && process.equals("deleteCustomer")) {
		  
		  cid=Integer.parseInt(request.getParameter("cid"));
		  
		  flag=cimpl.deleteCustomer(cid);
		  
		  if(flag) {
			   request.setAttribute("msg","Customer deleted successfully");
			   
			   clist=cimpl.showCustomer();
			   session.setAttribute("clist", clist);
			   
			   rd=request.getRequestDispatcher("customerlist.jsp");
			   rd.forward(request,response);
			   
		  }
		  else {
			  request.setAttribute("emsg", "Error while deleting customer");
			  
			  clist=cimpl.showCustomer();
			  session.setAttribute("clist",clist);
			  
			  rd=request.getRequestDispatcher("customerlist.jsp");
			  rd.forward(request,response);
		  }
   	  
	}
   	 
   	 else if(process!=null && process.equals("allCustomer")) {
   		 
   		 
		   clist=cimpl.showCustomer();
		   session.setAttribute("clist", clist);
		   
		   rd=request.getRequestDispatcher("customerlist.jsp");
		   rd.forward(request,response);
		  
   	 }
   	 
	
		
   	 else {
   		 cemail=(String)session.getAttribute("customer");
   		 c=cimpl.searchCustomer(cemail);
   		 
   		 session.setAttribute("uCust", c);
   		 //rd=request.getRequestDispatcher("UpdateCustomer.jsp");
   		 //rd.forward(request, response);
   		 
   		response.sendRedirect("UpdateCustomer.jsp");
   		 
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
		 if(process!=null && process.equals("addCustomer")) {
			 
			  // cid=Integer.parseInt(request.getParameter("cid"));
			   fname=request.getParameter("fname");
			   lname=request.getParameter("lname");
			   caddress=request.getParameter("caddress");
			   cemail=request.getParameter("cemail");
			   contact=request.getParameter("contact");
			   password=request.getParameter("password");
			   
			   c=new Customer();
			   
			  c.setFname(fname);
			  c.setLname(lname);
			  c.setCaddress(caddress);
			  c.setCemail(cemail);
			  c.setContact(contact);
			  c.setPassword(password);
			  
			  flag=cimpl.addCustomer(c);
			  
			  if(flag) {
					 
					 //clist=cimpl.showCustomer();
					 //session.setAttribute("clist", clist);
					 
					 request.setAttribute("msg", "Customer added successfully");
					 
					 rd=request.getRequestDispatcher("login.jsp");
					 rd.forward(request, response);
					 
				 }
			  
			  else {
					 request.setAttribute("emsg", "Error while adding customer");
					 rd=request.getRequestDispatcher("addCustomer.jsp");
					 rd.include(request, response);
				 }
		 }
		 else if(process!=null && process.equals("updateCust")) {
			  
			   cid=Integer.parseInt(request.getParameter("cid"));
			   fname=request.getParameter("fname");
			   lname=request.getParameter("lname");
			   caddress=request.getParameter("caddress");
			   cemail=request.getParameter("cemail");
			   contact=request.getParameter("contact");
			   
			   
			   c=cimpl.searchCustomer(cid);
			    
			   
			   
				  c.setFname(fname);
				  c.setLname(lname);
				  c.setCaddress(caddress);
				  c.setCemail(cemail);
				  c.setContact(contact);
				 
				  
				  flag= cimpl.updateCustomer(c);
				  
					if(flag) {
						 
						request.setAttribute("msg", "Customer updated successfully");
						
						//clist=cimpl.showCustomer();
						
						session.setAttribute("customer", null);
						
						rd=request.getRequestDispatcher("login.jsp");
						rd.forward(request, response);
					}
					else {
						
						request.setAttribute("emsg", "Error while customer updating" );
						//clist=cimpl.showCustomer();
						//session.setAttribute("clist", clist);
						rd=request.getRequestDispatcher("UpdateCustomer.jsp");
						rd.forward(request, response);
						
					}
		 }
	
	
	}

}
