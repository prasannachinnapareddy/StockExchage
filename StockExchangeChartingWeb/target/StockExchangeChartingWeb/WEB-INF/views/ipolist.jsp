<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ipo operations</title>
</head>
<body>
<c:url var="userUrl" value="/ipo/save"></c:url>
<form:form action="${userUrl }" modelAttribute="ipo">
<table>
<c:if test="${!empty ipo.companyName}">
	<tr>
			<td><form:label path="id">Id</form:label></td>
			<td><form:input path="id" readonly="true" disabled="true"></form:input>
			<form:hidden path="id"/>
			</td>
		</tr>
	</c:if>
	<tr>
			<td><form:label path="id">Id</form:label></td>
			<td><form:input path="id"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="companyName">Company Name</form:label></td>
			<td><form:input path="companyName"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="stockExchange">Stock Exchange</form:label></td>
			<td><form:input path="stockExchange"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="pricePerShare">Price Per Share</form:label></td>
			<td><form:input path="pricePerShare"></form:input></td>
		</tr>
		
		<tr>
			<td><form:label path="totalStocks">Total Stocks</form:label></td>
			<td><form:input path="totalStocks"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="remarks">Remarks</form:label></td>
			<td><form:input path="remarks"></form:input></td>
		</tr>
		
		
		<tr>
		<td></td>
		<td><c:if test="${empty ipo.companyName }">
			<input type="submit" value="submit"></c:if>
			<c:if test="${!empty ipo.companyName }">
			<input type="submit" value="update"></c:if>
			</td>
		</tr>
	</table>
</form:form>

<table border="1">
 <tr>
<th>Id</th>
<th>Companyname</th>
<th>Stockexchange</th>
<th>Pricepershare</th>
<th>Totalstocks</th>
<th>Remarks</th>
<th>Actions</th>
</tr>
<c:forEach var="ipo" items="${list}"> 
<tr>
<td>${ipo.id }</td>
<td>${ipo.companyName }</td>
<td>${ipo.stockExchange }</td>
<td>${ipo.pricePerShare }</td>
<td>${ipo.totalStocks }</td>
<td>${ipo.remarks }</td>
<td><a href="<c:url value='/ipo/remove/${ipo.id }'/>">Remove</a>|
<a href="<c:url value='/ipo/update/${ipo.id }'/>">Update</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>