<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function validate(element){
	
	if(element.value=="" && element.name=="fname"){
		
		element.nextSibling.innerHTML="Please enter name";
		return false;
	}
	
	else if(element.value=="" && element.name=="lname"){
		
		element.nextSibling.innerHTML="Please enter last name";
		return false;

	}
	
	else if(element.value=="" && element.name=="caddress"){
		
		element.nextSibling.innerHTML="Please enter address";
		return false;

	}
	else if(element.value=="" && element.name=="cemail"){
		
		element.nextSibling.innerHTML="Please enter email";
		return false;

	}
	else if(element.value=="" && element.name=="contact"){
		
		element.nextSibling.innerHTML="Please enter contact";
		return false;

	}
	else if(element.value=="" && element.name=="password"){
		
		element.nextSibling.innerHTML="Please enter password";
		return false;

	}
	
	
	else{
		
		element.nextSibling.innerHTML="*";

	}
	
}

function validateWithClass(){
	
	var arr=document.getElementsByClassName("validateMe");
	var flag=true;
	
	for(var i=0;i<arr.length;i++){
		
		var element=arr[i];
		
		flag=validate(element);
		
		if(flag==false){
			
			break;
		}
	}
	return flag;
}
</script>
</head>
<body>
<jsp:include page="msgs.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<form action="CustomerServlet" method="post" >
<input type="hidden" name="process" value="updateCust">
<table align="center" border="2">


<tr>
<th>Id: </th><td><input type="text" name="cid" class="validateMe" onblur="validate(this)"  value="${uCust.cid }" readonly="readonly"><span style="color:red">*</span></td>
</tr>

<tr>
<th>First Name: </th><td><input type="text" name="fname" class="validateMe" onblur="validate(this)"  value="${uCust.fname }"><span style="color:red;">*</span></td>
</tr>
<tr>
<th>Last Name: </th><td><input type="text" name="lname" class="validateMe" onblur="validate(this)" value="${uCust.lname }"><span style="color:red;">*</span></td>
</tr>

<tr>
<th>Address: </th><td><input type="text" name="caddress" class="validateMe" onblur="validate(this)" value="${uCust.caddress }"><span style="color:red">*</span></td>
</tr>

<tr>
<th>Email: </th><td><input type="text" name="cemail" class="validateMe" onblur="validate(this)" value="${uCust.cemail }"><span style="color:red">*</span></td>
</tr>

<tr>
<th>Contact: </th><td><input type="text" name="contact" class="validateMe" onblur="validate(this)" value="${uCust.contact }"><span style="color:red">*</span></td>
</tr>
<%-- 
<tr>
<th>Password: </th><td><input type="password" name="password" class="validateMe" onblur="validate(this)" value="${uCust.password }"><span style="color:red">*</span></td>
</tr>
--%>

<tr>
<td><input type="submit" value="UpdateCustomer" onclick="return validateWithClass()">
</td>
<td>
<input type="reset" value="Reset">
</td>
</tr>

</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>