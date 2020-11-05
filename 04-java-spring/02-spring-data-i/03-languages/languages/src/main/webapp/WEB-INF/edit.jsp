<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit and delete language</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>

<form:form method="POST" action="/edit/${id}" modelAttribute="language">
	<div class="form-group">
	<input type="hidden" name="_method" value="put">
	<a href="/">Dashboard</a>
	<form:label path="name">Name:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="creator">Creator Name:
	<form:errors path="creator"/>
	<form:input path="creator"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="version">Version:
	<form:errors path="version"/>
	<form:input path="version"/></form:label>
	</div>
	<button>Submit</button>
</form:form>
 <a href="/delete/${language.id}" class="btn btn-danger">Delete</a>
</body>
</html>