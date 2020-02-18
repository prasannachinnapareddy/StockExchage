<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Stock Price Operations</title>
</head>
<body>
<div class="container mt-5 w-50 card card-shadow shadow p-5 lg-5 bg-white rounded" >
	<h3 class="text-center">Please Fill Form</h3><br>
	<c:url var="userUrl" value="/stockPrice/save"></c:url>
	<form:form action="${userUrl}" modelAttribute="stockPrice">
		
			<c:if test="${!empty stockPrice.openDateTime}">
				<div class="form-group">
					<form:label path="id" class="text-primary h5">Id</form:label>
					<form:input path="id" readonly="true" class="form-control" disabled="true"></form:input>
						<form:hidden path="id" />
				</div>
			</c:if>

			<div class="form-group">
				<form:label path="companyId" class="text-primary h5">Company Id</form:label>
				<form:input path="companyId" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="currentPrice" class="text-primary h5">Current Price</form:label>
				<form:input path="currentPrice" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="openDateTime" class="text-primary h5">Date</form:label>
				<form:input type="datetime-local" class="form-control" path="openDateTime"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="openDateTime" class="text-primary h5">Time</form:label>
				<form:input type="datetime-local" class="form-control" path="openDateTime"></form:input>
			</div>
			
			<div class="form-group">
				<c:if test="${empty stockPrice.openDateTime }">
						<input type="submit" class="btn btn-success" value="Register">
					</c:if> <c:if test="${!empty stockPrice.openDateTime }">
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
			<th>CompanyId</th>
			<th>CurrentPrice</th>
			<th>Date</th>
			<th>Time</th>

		</tr>
		<c:forEach var="stockPrice" items="${list}">
			<tr>
				<td>${stockPrice.id }</td>
				<td>${stockPrice.companyId }</td>
				<td>${stockPrice.currentPrice }</td>
				<td>${stockPrice.openDateTime }</td>

				<td><a
					href="<c:url value='/stockPrice/remove/${stockPrice.id }'/>">Remove</a> |
					<a href="<c:url value='/stockPrice/update/${stockPrice.id }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>