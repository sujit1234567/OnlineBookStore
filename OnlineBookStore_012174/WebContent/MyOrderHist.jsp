<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.book.pojo.Order"%>
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
List<Order> olist=(List<Order>)session.getAttribute("myOH");
%>

<table border="2" align="center">
<tr>
<th>Order Id</th>
<th>Status</th>
<th>Date</th>
<th>Email</th>
<th>Total bill</th>

</tr>

<% for(Order o: olist) {%>

<tr>
<td><%= o.getOrderId() %></td>
<td><%= o.getOrderStatus() %></td>
<td><%= o.getOrderDate() %></td>
<td><%= o.getCemail() %></td>
<td><%= o.getTotalBill() %></td>
</tr>
<%} %>
</table>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>