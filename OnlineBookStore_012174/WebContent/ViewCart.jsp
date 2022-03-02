<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.5.1.js"></script>
<script type="text/javascript">
$(function(){
	
	$(".qty").click(function(){
		
		var q=this.value;
		var id=this.nextSibling.value;
		
		$.post("CartServlet", 
				{
			    
			    "Quantity":q,
			    "Cid":id,
			    "process":"updateQuantity"
				}
				
		);
	});

});

function billing(){
	
	var q=$(".qty");
	var p=$(".price");
	var total=0;
	
	for(var i=0;i<q.length;i++){
		
		total+=(q[i].value*p[i].value);
	}
	
	$("#bill").val(total);
}

$(function(){
	
	$(".qty").click(function(){
		
		var q=$(".qty");
		
		for(var i=0;i<q.length;i++){
			
			if(q[i].value<1){
				
				q[i].value=1;
			
				var id=q[i].nextSibling.value;
				
				$.post("CartServlet", 
						
				  {
					"Quantity":1,
				    "Cid":id,
				    "process":"updateQuantity"
				  }
				);
			}
			else{
				
				billing();
			}
		}
	});
	billing();
});


</script>
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
<th>Action</th>
</tr>

<c:forEach var="cart" items="${myCList }">
<tr>
<td><input type="text" name="cartId" value="${cart.cartId }" readonly="readonly"></td>
<td><input type="text" name="bookname" value="${cart.bookname }" readonly="readonly"></td>
<td><input type="number" name="quantity" value="${cart.quantity }" class="qty" ><input type="hidden" value="${cart.cartId }"></td>
<td><input type="text" name="bookprice" class="price" value="${cart.bookprice }" readonly="readonly"></td>
<td><a href="CartServlet?cartid=${cart.cartId }&process=deleteCart" >Delete</a></td>
</tr>
</c:forEach>

<tr><td colspan="3" style="text-align: right;">Total bill:</td><td colspan="2"><input name="bill" id= "bill"></td></tr>

<tr><td colspan="5" align="center"><input type="submit" value="Place Order"></td></tr>
</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>