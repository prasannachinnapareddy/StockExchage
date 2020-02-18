<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
 <tr>
<th>Id</th>
<th>Companyname</th>
<th>Stockexchange</th>
<th>Pricepershare</th>
<th>Totalstocks</th>
<th>Remarks</th>
</tr>
<c:forEach var="ipo" items="${list}"> 
<tr>
<td>${ipo.id }</td>
<td>${ipo.companyName }</td>
<td>${ipo.stockExchange }</td>
<td>${ipo.pricePerShare }</td>
<td>${ipo.totalStocks }</td>
<td>${ipo.remarks }</td>

</tr>
</c:forEach>
</table>

</body>
</html>