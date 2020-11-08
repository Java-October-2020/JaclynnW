<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Look at this license I made</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>${person.firstName} ${person.lastName}</h1>
<table class="table table-light">
	<thead>
		<th>License Number</th>
		<th>State</th>
		<th>Expiration Date</th>
	</thead>
	<tbody>
		<td>${person.license.getNumber()}</td>
		<td>${person.license.getState() }</td>
		<td>${person.license.getExpiration_date() }</td>
	</tbody>
</table>

</div>
</body>
</html>