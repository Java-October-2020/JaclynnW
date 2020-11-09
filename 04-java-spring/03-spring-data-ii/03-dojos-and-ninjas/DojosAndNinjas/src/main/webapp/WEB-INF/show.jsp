<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninjas at the Dojo</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>${dojo.name} Ninjas</h1>
<table class="table table-light">
	<thead>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Age</th>
	</thead>
	<tbody>
	<c:forEach items="${dojo.ninjas}" var="ninja">
	<tr>
		<td>${ninja.firstName}</td>
		<td>${ninja.lastName}</td>
		<td>${ninja.age}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>

</div>
</body>
</html>