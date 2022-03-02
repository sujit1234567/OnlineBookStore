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

<form action="LoginServlet" method="post">
<input type="hidden" name="process" value="login">
<table align="center">
<tr>
<th>Type: </th>
<td>
<select name="utype">
<option value="Customer">Customer</option>
<option value="Admin">Admin</option>

</select>
</td>
</tr>

<tr>
<th>Email: </th>
<td><input type="text" name="uEmail"></td>
</tr>


<tr>
<th>Password: </th>
<td><input type="password" name="uPassword"></td>
</tr>

<tr>
<td><input type="reset" value="Reset"></td>
 <td><input type="submit" value="Login">
<!-- &nbsp;&nbsp;&nbsp;<a href="Forgot.jsp">Forgot password</a></td>-->
<td></td>
</tr>

</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>