<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>IPO Operations</title>
</head>
<body>
<div class="container mt-5 w-75 h-50 card card-shadow shadow p-5 lg-5 bg-white rounded" >
	<h3 class="text-center">Please Fill Form</h3><br>
	<c:url var="userUrl" value="/ipo/save"></c:url>
	<form:form action="${userUrl }" modelAttribute="ipo">
			<c:if test="${!empty ipo.companyName}">
				<div class="form-group">
					<form:label path="id">Id</form:label>
					<form:input path="id" readonly="true" disabled="true"></form:input>
						<form:hidden path="id" />
				</div>			
				</c:if>

			<div class="form-group">
				<form:label path="companyName" class="text-primary h5">Company Name</form:label>
				<form:input path="companyName" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="stockExchange" class="text-primary h5">Stock Exchange</form:label>
				<form:input path="stockExchange" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="pricePerShare" class="text-primary h5">Price Per Share</form:label>
				<form:input path="pricePerShare" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="totalStocks" class="text-primary h5">Total Stocks</form:label>
				<form:input path="totalStocks" class="form-control"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="remarks" class="text-primary h5">Remarks</form:label>
				<form:input path="remarks" class="form-control"></form:input>
			</div>

			<div class="form-group">
					<c:if test="${empty ipo.companyName }">
						<input type="submit" class="btn btn-success" value="Register">
					</c:if> 
					<c:if test="${!empty ipo.companyName }">
						<input type="submit" class="btn btn-success" value="Update">
					</c:if>
			</div>
	</form:form>
	</div><br>
	<table class="table table-striped">
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
				<td><a href="<c:url value='/ipo/remove/${ipo.id }'/>">Remove</a> |
					<a href="<c:url value='/ipo/update/${ipo.id }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>