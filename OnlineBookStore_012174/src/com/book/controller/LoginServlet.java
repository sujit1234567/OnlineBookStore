package com.book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.LoginDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    LoginDaoImpl limpl=new LoginDaoImpl();
    boolean flag;
    HttpSession session;
    RequestDispatcher rd;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		
		session=request.getSession();
		
		if(process!=null && process.equals("logOut")) {
			
			session.invalidate();
			request.setAttribute("msg", "You have logged out!!");
			
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		 String process=request.getParameter("process");
		 session=request.getSession();
		 if(process!=null && process.equals("login")){
			 
			 String userType=request.getParameter("utype");
			 String email=request.getParameter("uEmail");
			 String password=request.getParameter("uPassword");
		    
			 if(userType.equals("Customer")) {
				 
				 flag=limpl.isOurCustomer(email, password);
				 
				if(flag) {
					
					request.setAttribute("msg", "Login successful!!");
					
					session.setAttribute("customer", email);
				    
					rd=request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);
				}
				else {
					
					request.setAttribute("emsg", "Email or Password is incorrect");
					
					rd=request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				    	
				}
			 }
			 else if(userType.equals("Admin")) {
				 
				 flag=limpl.isOurAdmin(email, password);
				 
				 if(flag) {
						
						request.setAttribute("msg", "Login successful!!");
						
						session.setAttribute("admin", email);
					    
						rd=request.getRequestDispatcher("home.jsp");
						rd.forward(request, response);
					}
					else {
						
						request.setAttribute("emsg", "Email or Password is incorrect");
						
						rd=request.getRequestDispatcher("login.jsp");
						rd.forward(request, response);
					    	
					}
			 }
		 }
	}

}
