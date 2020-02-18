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
<title>Insert title here</title>
</head>
<body>
<c:url var="userUrl" value="/stockPrice/save"></c:url>
<form:form action="${userUrl}" modelAttribute="stockPrice">
<table>
	<tr>
			<td><form:label path="id">Id</form:label></td>
			<td><form:input path="id"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="companyId">Company Id</form:label></td>
			<td><form:input path="companyId"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="currentPrice">Current Price</form:label></td>
			<td><form:input path="currentPrice"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="date">Date</form:label></td>
			<td><form:input type="LocalDate" path="date"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="time">Time</form:label></td>
			<td><form:input type="LocalTime" path="time"></form:input></td>
		</tr>
		
		<tr>
			<td><button type="submit">submit</button></td>
		</tr>
	</table>
</form:form>

</body>
</html>