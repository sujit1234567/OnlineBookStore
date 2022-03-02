<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.book.pojo.Book"%>
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
List<Book> blist=(List<Book>)session.getAttribute("blist");
%>

<table border="2" align="center">
<tr>
<th>Id</th>
<th>Name</th>
<th>Author</th>
<th>Price</th>
<th>Publisher</th>
<th>No. of Copies</th>
<th>Description</th>
<th>Rating</th>
<th>Category</th>
<th>Image</th>
<th colspan="2">Action</th>
</tr> 

<% for(Book b: blist) {%>

<tr>
<td><%= b.getBookid() %></td>
<td><%= b.getBookname() %></td>
<td><%= b.getAuthor() %></td>
<td><%= b.getBookprice() %></td>
<td><%= b.getPublisher() %></td>
<td><%= b.getNoOfCopies() %></td>
<td><%= b.getDescription() %></td>
<td><%= b.getRating() %></td>
<td><%= b.getCategory() %></td>
<td><img alt="" src="ImageServlet?bookid=<%= b.getBookid() %>" height="100" width="70"></td>
<td><a href="BookServlet?bookid=<%= b.getBookid() %>&process=updateBook">Update</a></td>
<td><a href="BookServlet?bookid=<%= b.getBookid() %>&process=deleteBook" onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
</tr>
<%} %>

</table>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>