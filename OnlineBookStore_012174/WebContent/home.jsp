<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="leftSideMenu.jsp"></jsp:include>       
<div id="templatemo_content_right">

<c:forEach var="book" items="${blist }">        	
        	<div class="templatemo_product_box">
            	<h1>${book.bookname }  <span></span></h1>
   	      <img alt="" src="ImageServlet?bookid=${book.bookid }" height="100" width="70">
                <div class="product_info">
                	<p>${book.description }...</p>
                  <h3>Rs. ${book.bookprice }</h3>
                    <div class="buy_now_button"><a href="CartServlet?bookid=${book.bookid }&process=addToCart">Add to Cart</a></div>
                    <div class="detail_button"><a href="BookServlet?process=viewBook&bookid=${book.bookid }" target="_blank">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
              
            </div>
            </c:forEach>
<jsp:include page="footer.jsp"></jsp:include>            
</body>
</html>