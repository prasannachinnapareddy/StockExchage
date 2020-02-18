<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<table border="1">
 <tr>
<th>Id</th>
<th>Username</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Email</th>
<th>Phone</th>
<th>Password</th>
</tr>
<c:forEach var="register" items="${list}"> 
<tr>
<td>${register.id }</td>
<td>${register.username }</td>
<td>${register.firstname }</td>
<td>${register.lastname }</td>
<td>${register.email }</td>
<td>${register.phone }</td>
<td>${register.password }</td>
</tr>
</c:forEach>
</table>


</body>
</html>