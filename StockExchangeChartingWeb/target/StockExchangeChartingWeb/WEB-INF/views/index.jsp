<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<html>
<body>
<h2>Hello World!</h2>
<hr>
${message}
<hr>
 <ol>
<c:forEach var="name" items="${list}">
<li>${name}</li>
</c:forEach>
</ol>


</body>
</html>
