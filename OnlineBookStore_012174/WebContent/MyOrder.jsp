<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
<table align="center" border="2">
<tr>
<th>Order No.</th><td>${myOrder.orderId }</td>
</tr>

<tr>
<th>Status</th><td>${myOrder.orderStatus }</td>
</tr>

<tr>
<th>Date</th><td>${myOrder.orderDate }</td>
</tr>

<tr>
<th>Email</th><td>${myOrder.cemail }</td>
</tr>

<tr>
<th>Total bill</th><td>${myOrder.totalBill }</td>
</tr>


</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>