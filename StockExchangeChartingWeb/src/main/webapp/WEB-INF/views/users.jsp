
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Register operations</title>
</head>
<body>
<div class="container mt-5 w-75 h-50 card card-shadow shadow p-5 lg-5 bg-white rounded">
	<h1>Please Fill Form</h1>
	<c:url var="userUrl" value="/user/save"></c:url>
	<form:form action="${userUrl}" modelAttribute="user">
	<div class="container-fluid">
			<c:if test="${!empty user.username}">
				<div class="form-group">
					<form:label path="id">Id</form:label>
					<form:input path="id" readonly="true" class="form-control" disabled="true"></form:input>
					<form:hidden path="id" />
				</div>
			</c:if>

			
			<div class="form-group">
				<form:label path="username" class="text-primary h5">UserName</form:label>
				<form:input path="username" class="form-control text-primary"></form:input>
			</div>
			
			<div class="form-group">
			<form:label path="firstname" class="text-primary h5">FirstName</form:label>
			<form:input path="firstname"  class="form-control"></form:input>
			</div>
	
			<div class="form-group">
				<form:label path="lastname" class="text-primary h5">LastName</form:label>
				<form:input path="lastname"  class="form-control"></form:input>
			</div>

			<div class="form-group">
				<form:label path="email" class="text-primary h5">email</form:label>
				<form:input path="email" class="form-control"></form:input>
			</div>
			
			<div class="form-group" >
				<form:label path="phone" class="text-primary h5">Phone</form:label>
				<form:input path="phone" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="password" class="text-primary h5">password</form:label>
				<form:input path="password" class="form-control"></form:input>
			</div>

				<div class="form-group">
				<c:if test="${empty register.username }">
						<input type="submit" class="btn btn-success" value="Register">
				</c:if> 
				<c:if test="${!empty register.username }">
						<input type="submit" class="btn btn-success" value="Update">
				</c:if>
				</div>
				
			</div>
	</form:form>
	</div>
	<br>
	<div>
		<table class="table table-striped">
			<tr>
				<th>Id</th>
				<th>UserName</th>
				<th>FirstName</th>
				<th>LastName</th>
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
					<td><a href="<c:url value='/remove/${register.id }'/>">Remove</a> |
						<a href="<c:url value='/update/${register.id }'/>">Update</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>