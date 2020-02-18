<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company</title>
</head>
<body>
<table border="1">
 <tr>
<th>Id</th>
<th>Companyname</th>
<th>Sector</th>
<th>Ceo</th>
<th>Bod</th>
<th>Turnover</th>
</tr>
<c:forEach var="company" items="${list}"> 
<tr>
<td>${company.id }</td>
<td>${company.companyname }</td>
<td>${company.sector }</td>
<td>${company.ceo }</td>
<td>${company.bod }</td>
<td>${company.turnover }</td>

</tr>
</c:forEach>
</table>

</body>
</html>