<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
<form action="OrderServlet" method="post">
<input type="hidden" name="process" value="placeOrder">
<table align="center">

<tr>
<th>Cart id</th>
<th>Book name</th>
<th>Quantity</th>
<th>Book price</th>
<th>Email</th>
<th>Action</th>
</tr>

<c:forEach var="cart" items="${allCartCopy }">
<tr>
<td><input type="text" name="cartId" value="${cart.cartId }" readonly="readonly"></td>
<td><input type="text" name="bookname" value="${cart.bookname }" readonly="readonly"></td>
<td><input type="text" name="quantity" value="${cart.quantity }" class="qty" readonly="readonly"></td>
<td><input type="text" name="bookprice" class="price" value="${cart.bookprice }" readonly="readonly"></td>
<td><input type="text" value="${cart.cemail}" name="cemail"></td>
<td><a href="BookServlet?process=updateCopies&cartId=${cart.cartId }" >Packed</a></td>
</tr>
</c:forEach>

</table>
</form>
<jsp:include page="footer.jsp"></jsp:include></body>
</html>