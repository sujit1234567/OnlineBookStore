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
<form action="ForgotServlet" method="post">
<input type="hidden" name="process" value="forgot">

<table  align="center">
<tr>
<tr>
<th>New password: </th>
<td><input type="password" name="nPass" ></td>

</tr>


<tr>
<th>Confirm password: </th>
<td><input type="password" name="cPass"></td>
</tr>

<tr>
<td><input type="reset" value="Reset"></td>
<td><input type="submit" value="Submit"></td>
<td></td>
</tr>


</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>