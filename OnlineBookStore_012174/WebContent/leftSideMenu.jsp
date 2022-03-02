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
 <div id="templatemo_content_left">
        	<div class="templatemo_content_left_section">
            	<h1>Categories</h1>
                <ul>
                <c:forEach var="cat" items="${allCats }">
                    <li><a href="BookServlet?process=getBooksByCategory&category=${cat }">${cat }</a></li>
                    </c:forEach>
            	</ul>
            </div>
			<div class="templatemo_content_left_section">
            	<h1>Authors</h1>
                <ul>
                    <c:forEach var="author" items="${allAuthors }">
                    <li><a href="BookServlet?process=getBooksByAuthor&author=${author }"><c:out value="${author }"></c:out></a></li>
                     </c:forEach>
                    </ul>
            </div>
            
            <div class="templatemo_content_left_section">                
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
			</div>
        </div> <!-- end of content left -->
        
</body>
</html>