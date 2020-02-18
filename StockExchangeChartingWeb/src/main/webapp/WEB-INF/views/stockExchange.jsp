<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Stock Exchange Operations</title>
</head>
<body>
<div class="container mt-5 w-50 card card-shadow shadow p-5 lg-5 bg-white rounded" >
	<c:url var="userUrl" value="/stockExchange/save"></c:url>
	<h3 class="text-center">Please Fill Form</h3><br>
	<form:form action="${userUrl }" modelAttribute="stockExchange">
			<c:if test="${!empty stockExchange.exchangeName}">
				<div class="form-group">
					<form:label path="id" class="text-primary h5" >Id</form:label>
					<form:input path="id" readonly="true" class="form-control" disabled="true"></form:input>
						<form:hidden path="id" />
				</div>
			</c:if>
			<div class="form-group">
				<form:label path="exchangeName" class="text-primary h5">Exchange Name</form:label>
				<form:input path="exchangeName" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="contractAddress" class="text-primary h5">Contact Address</form:label>
				<form:input path="contractAddress" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="brief" class="text-primary h5">Brief</form:label>
				<form:input path="brief" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="remarks" class="text-primary h5">Remarks</form:label>
				<form:input path="remarks" class="form-control"></form:input>
			</div>

			<div class="form-group">
				
				<c:if test="${empty stockExchange.exchangeName }">
						<input type="submit" class="btn btn-success" value="Register">
					</c:if> <c:if test="${!empty stockExchange.exchangeName }">
						<input type="submit" class="btn btn-success" value="Update">
					</c:if>
					</div>
	</form:form>
	</div>
	<br>

	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>ExchangeName</th>
			<th>ContractAddress</th>
			<th>Brief</th>
			<th>Remarks</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="stockExchange" items="${list}">
			<tr>
				<td>${stockExchange.id }</td>
				<td>${stockExchange.exchangeName }</td>
				<td>${stockExchange.contractAddress }</td>
				<td>${stockExchange.brief }</td>
				<td>${stockExchange.remarks }</td>
				<td><a
					href="<c:url value='/stockExchange/remove/${stockExchange.id }'/>">Remove</a> |
					<a
					href="<c:url value='/stockExchange/update/${stockExchange.id }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>