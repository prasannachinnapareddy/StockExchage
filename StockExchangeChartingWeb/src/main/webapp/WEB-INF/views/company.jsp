<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Company Operations</title>
</head>
<body>
<div class="container mt-5 w-75 h-50 card card-shadow shadow p-5 lg-5 bg-white" >
	<h3 class="text-center">Please Fill Form</h3><br>
	<c:url var="userUrl" value="/company/save"></c:url>
	<form:form action="${userUrl }" modelAttribute="company">
		
			<c:if test="${!empty company.companyname}">
					<div class="form-group">	
						<form:label path="id">Id</form:label>
						<form:input path="id" readonly="true" disabled="true"></form:input>
						<form:hidden path="id" />
					</div>
			</c:if>

	
			<div class="form-group">	
				<form:label path="companyname" class="text-primary h5">CompanyName</form:label>
				<form:input path="companyname" class="form-control"></form:input>
			</div>
			
			<div class="form-group">	
				<form:label path="sector" class="text-primary h5">Sector</form:label>
				<form:input path="sector" class="form-control"></form:input>
			</div>
			
			<div class="form-group">	
				<form:label path="ceo" class="text-primary h5">CEO</form:label>
				<form:input path="ceo" class="form-control"></form:input>
			</div>
			
			<div class="form-group">	
				<form:label path="bod" class="text-primary h5">BOD</form:label>
				<form:input path="bod" class="form-control"></form:input>
			</div>
			
			<div class="form-group">	
				<form:label path="turnover" class="text-primary h5">Turnover</form:label>
				<form:input path="turnover" class="form-control"></form:input>
			</div>

			<div class="form-group">	
				<c:if test="${empty company.companyname }">
						<input type="submit" class="btn btn-success" value="Register">
					</c:if> <c:if test="${!empty company.companyname }">
						<input type="submit" class="btn btn-success" value="Update">
					</c:if>
			</div>
		</div>
	</form:form>
	<br>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>CompanyName</th>
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
				<td><a href="<c:url value='/company/remove/${company.id }'/>">Remove</a> |
					<a href="<c:url value='/company/update/${company.id }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>