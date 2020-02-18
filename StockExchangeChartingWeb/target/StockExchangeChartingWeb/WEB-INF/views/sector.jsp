<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sector</title>
</head>
<body>
<table border="1">
 <tr>
<th>Id</th>
<th>Name</th>
<th>Brief</th>

</tr>
<c:forEach var="sector" items="${list}"> 
<tr>
<td>${sector.id }</td>
<td>${sector.name }</td>
<td>${sector.brief }</td>

</tr>
</c:forEach>
</table>

</body>
</html>