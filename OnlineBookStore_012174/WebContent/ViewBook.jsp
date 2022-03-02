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

<table border="2" align="center">
<tr><th>Id</th><td>${vBook.bookid }</td></tr>
<tr><th>Name</th><td>${vBook.bookname }</td></tr>
<tr><th>Author</th><td>${vBook.author }</td></tr>
<tr><th>Price</th><td>${vBook.bookprice }</td></tr>
<tr><th>Publisher</th><td>${vBook.publisher }</td></tr>
<tr><th>No. of Copies</th><td>${vBook.noOfCopies }</td></tr>
<tr><th>Description</th><td>${vBook.description }</td></tr>
<tr><th>Rating</th><td>${vBook.rating }</td></tr>
<tr><th>Category</th><td>${vBook.category }</td></tr>
<tr><th>Image</th><td><img alt="" src="ImageServlet?bookid=${vBook.bookid }" height="100" width="70"></td></tr>
<jsp:include page="footer.jsp"></jsp:include>
</table>
</body>
</html>