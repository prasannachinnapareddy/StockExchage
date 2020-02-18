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
<title>Company Operations</title>
</head>
<body>
<c:url var="userUrl" value="/company/save"></c:url>
<form:form action="${userUrl }" modelAttribute="company">
	<table>
	<c:if test="${!empty company.companyname}">
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
			<td><form:label path="companyname">Companyname</form:label></td>
			<td><form:input path="companyname"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="sector">Sector</form:label></td>
			<td><form:input path="sector"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="ceo">CEO</form:label></td>
			<td><form:input path="ceo"></form:input></td>
		</tr>
		
		<tr>
			<td><form:label path="bod">BOD</form:label></td>
			<td><form:input path="bod"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="turnover">Turnover</form:label></td>
			<td><form:input path="turnover"></form:input></td>
		</tr>
		
		
		<tr>
		<td></td>
		<td><c:if test="${empty company.companyname }">
			<input type="submit" value="submit"></c:if>
			<c:if test="${!empty company.companyname }">
			<input type="submit" value="update"></c:if>
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
 <tr>
<th>Id</th>
<th>Companyname</th>
<th>Sector</th>
<th>Ceo</th>
<th>Bod</th>
<th>Turnover</th>
<th>Action</th>
</tr>
<c:forEach var="company" items="${list}"> 
<tr>
<td>${company.id }</td>
<td>${company.companyname }</td>
<td>${company.sector }</td>
<td>${company.ceo }</td>
<td>${company.bod }</td>
<td>${company.turnover }</td>
<td><a href="<c:url value='/company/remove/${company.id }'/>">Remove</a>|
<a href="<c:url value='/company/update/${company.id }'/>">Update</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>