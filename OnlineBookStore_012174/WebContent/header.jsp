<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--  Free CSS Templates from www.templatemo.com -->
<%
String customer=(String)session.getAttribute("customer");
String admin=(String)session.getAttribute("admin");

%>
<div id="templatemo_container">
	<div id="templatemo_menu">
    	<ul>
    	<%if(admin==null && customer==null){ %>
            <li><a href="index.jsp" class="current">Home</a></li>
             <li><a href="addCustomer.jsp" class="current">Register</a></li>
             <li><a href="login.jsp">Login</a></li>
            <%} %>
           
            <%if(admin!=null && customer==null) {%>
            <li><a href="addBook.jsp" class="current">Add Book</a></li>
            <li><a href="CustomerServlet?process=allCustomer" class="current">All Customer</a></li>
            <li><a href="CartServlet?process=allCart" class="current">Entire Cart</a></li>
            <li><a href="BookServlet?process=allBooks" class="current">All Books</a></li>
            <li><a href="OrderServlet?process=allOrders" class="current">All Orders</a></li>
            
            <%} %>
            
            <% if(admin==null && customer!=null){ %>
               <li><a href="CustomerServlet" class="current">My Profile</a></li>
               <li><a href="CartServlet?process=myCart" class="current">My Cart</a></li>
               <li><a href="OrderServlet?process=myOrderHistory" class="current">My Order History</a></li>                   
              <%--  <li><a href="CustomerServlet?process=changePass" class="current">Change Password</a></li> --%>  
            <%} %>
            
              <% if(admin!=null || customer!=null){ %>
                  <li><a href="index.jsp" class="current">Home</a></li>
                  <li><a href="LoginServlet?process=logOut" class="current">Log out</a></li>
            
            <%} %>
                          
            
    	</ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>25%</span> discounts for
        purchase over Rs. 1000
        	</p>
			<a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>Ramayan</li>
                <li>Mahabharat</li>
                <li>Java</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->
    
    <div id="templatemo_content">
</body>
</html>