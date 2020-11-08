<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top 10</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h3>Top Ten Songs:</h3>
<a class="float-righ" href="/dashboard">Dashboard</a>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>Rating</th>
			<th>Title</th>
			<th>Artist</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${songs}" var="song">
		<tr>
			<td>${song.rating}</td>
			<td><a href="/songs/${song.id}">${song.title}</a></td>
			<td>${song.artist}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>