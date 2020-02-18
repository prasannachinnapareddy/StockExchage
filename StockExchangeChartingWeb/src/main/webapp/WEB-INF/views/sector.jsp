<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Sector Operations</title>
</head>
<body>
<div class="container mt-5 w-50 card card-shadow shadow p-5 lg-5 bg-white rounded" >
	<c:url var="userUrl" value="/sector/save"></c:url>
	<h3 class="text-center">Please Fill Form</h3><br>
	<form:form action="${userUrl }" modelAttribute="sector">
			<c:if test="${!empty sector.name}">
				<div class="form-group">
					<form:label path="id" class="text-primary h5">Id</form:label>
					<form:input path="id" readonly="true" class="form-control" disabled="true"></form:input>
						<form:hidden path="id" />
				</div>
			</c:if>

			<div class="form-group">
				<form:label path="name" class="text-primary h5">Sector Name</form:label>
				<form:input path="name" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="brief" class="text-primary h5">Brief</form:label>
				<form:input path="brief" class="form-control"></form:input>
			</div>

			<div class="form-group">
				<c:if test="${empty sector.name }">
						<input type="submit" class="btn btn-success" value="Register">
				</c:if> 
				<c:if test="${!empty sector.name }">
						<input type="submit" class="btn btn-success" value="Update">
				</c:if>
			</div>
	</form:form>
	</div>
	<br>
	<br>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Brief</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="sector" items="${list}">
			<tr>
				<td>${sector.id }</td>
				<td>${sector.name }</td>
				<td>${sector.brief }</td>
				<td><a href="<c:url value='/sector/remove/${sector.id }'/>">Remove</a> |
					<a href="<c:url value='/sector/update/${sector.id }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>