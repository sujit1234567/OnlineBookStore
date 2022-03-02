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
List<Order> olist=(List<Order>)session.getAttribute("allO");
%>

<%
if(!(olist.isEmpty())){
%>
<table border="2" align="center">
<tr>
<th>Order Id</th>
<th>Status</th>
<th>Date</th>
<th>Email</th>
<th>Total bill</th>
<th colspan="2">Action</th>
</tr>

<% for(Order o: olist) {%>

<tr>
<td><%= o.getOrderId() %></td>
<td><%= o.getOrderStatus() %></td>
<td><%= o.getOrderDate() %></td>
<td><%= o.getCemail() %></td>
<td><%= o.getTotalBill() %></td>
<td><a href="OrderServlet?process=updateStatus&orderId=<%= o.getOrderId() %>">Update Status</a></td>
<td><a href="OrderServlet?process=cancelOrder&orderId=<%= o.getOrderId() %>">Cancel Order</a></td>
</tr>
<%} %>
</table>
<%} 

else{
	out.print("<h2>No data to display!!</h3>");
}
%>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>