<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.book.pojo.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<%
List<Customer> clist=(List<Customer>)session.getAttribute("clist");
%>

<table border="2" align="center">
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Address</th>
<th>Email</th>
<th>Contact</th>

<th colspan="2">Action</th>
</tr>

<% for(Customer c: clist) {%>

   <tr>
   <td><%= c.getCid() %></td>
   <td><%= c.getFname() %></td>
   <td><%= c.getLname() %></td>
   <td><%= c.getCaddress() %></td>
   <td><%= c.getCemail() %></td>
   <td><%= c.getContact() %></td>

   <td><a href="CustomerServlet?cid=<%= c.getCid() %>&process=updateCustomer">Update</a></td> 
   <td><a href="CustomerServlet?cid=<%= c.getCid() %>&process=deleteCustomer" onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
</tr>
<%} %>
</table>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>