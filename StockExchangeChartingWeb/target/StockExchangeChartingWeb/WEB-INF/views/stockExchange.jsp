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
<th>ExchangeName</th>
<th>ContractAddress</th>
<th>Brief</th>
<th>Remarks</th>

</tr>
<c:forEach var="stockExchange" items="${list}"> 
<tr>
<td>${stockExchange.id }</td>
<td>${stockExchange.exchangeName }</td>
<td>${stockExchange.contractAddress }</td>
<td>${stockExchange.brief }</td>
<td>${stockExchange.remarks }</td>

</tr>
</c:forEach>
</table>

</body>
</html>