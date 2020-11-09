<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
<title>Add Ninja</title>
</head>
<body>
<div class="container">
<h1>New Ninja</h1>
<form:form method="Post" action="/ninjas/new" modelAttribute="ninjas">
	<div class="form-group">
	<form:label path="dojo">Dojo Name:</form:label>
	<form:errors path="dojo"/>
	<form:select class="form-control" path="dojo">
	<c:forEach items="${dojos}" var="dojo">
		<form:option value="${dojo.id}">${dojo.name}</form:option>
	</c:forEach>
	</form:select>
	</div>
	<div class="form-group">
	<form:label path="firstName">First Name:
	<form:errors path="firstName"/>
	<form:input path="firstName"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="lastName">Last Name:
	<form:errors path="lastName"/>
	<form:input path="lastName"/></form:label>
	</div>
			<div class="form-group">
	<form:label path="age">Age:
	<form:errors path="age"/>
	<form:input path="age"/></form:label>
	</div>
	<button>Create</button>
</form:form>
</div>
</body>
</html>