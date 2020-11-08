<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a license</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>New License</h1>
<form:form method="Post" action="/licenses/new" modelAttribute="license">
	<div class="form-group">
	<form:label path="person">Person:</form:label>
	<form:errors path="person"/>
	<form:select class="form-control" path="person">
	<c:forEach items="${persons}" var="person">
		<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
	</c:forEach>
	</form:select>
	</div>
	<div class="form-group">
	<form:label path="state">State:
	<form:errors path="state"/>
	<form:input path="state"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="expiration_date">Expiration:
	<form:errors path="expiration_date"/>
	<form:input type="date" clasee="form-control" path="expiration_date"/></form:label>
	</div>
	<button>Create</button>
</form:form>
</div>

</body>
</html>