
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
<c:url var="userUrl" value="/user/save"></c:url>
<form:form action="${userUrl}" modelAttribute="user">
	<table>
	<c:if test="${!empty user.username}">
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
			<td><form:label path="username">Username</form:label></td>
			<td><form:input path="username"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="firstname">Firstname</form:label></td>
			<td><form:input path="firstname"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="lastname">Lastname</form:label></td>
			<td><form:input path="lastname"></form:input></td>
		</tr>
		
		<tr>
			<td><form:label path="email">email</form:label></td>
			<td><form:input path="email"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="phone">Phone</form:label></td>
			<td><form:input path="phone"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="password">password</form:label></td>
			<td><form:input path="password"></form:input></td>
		</tr>
		
		
		<tr>
		<td></td>
		<td><c:if test="${empty register.username }">
			<input type="submit" value="register"></c:if>
			<c:if test="${!empty register.username }">
			<input type="submit" value="update"></c:if>
			</td>
		</tr>
	</table>
</form:form><br>
<div>
<table border="1">
 <tr>
<th>Id</th>
<th>Username</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Email</th>
<th>Phone</th>
<th>Password</th>
<th>Actions</th>
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
<td><a href="<c:url value='/remove/${register.id }'/>">Remove</a>|
<a href="<c:url value='/update/${register.id }'/>">Update</a></td>
</tr>
</c:forEach>
</table>

</div>
</body>
</html>