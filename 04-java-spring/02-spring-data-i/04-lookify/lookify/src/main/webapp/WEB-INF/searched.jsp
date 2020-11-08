<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h3>Songs by artist: ${song.artist}</h3>
<form action="/songs/search" class="float-right">
	<input type="text" name="artist"/>
	<button class="btn btn-primary">Search Artist</button>
</form>
<a class="float-right" href="/dashboard">Dashboard</a>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>Title</th>
			<th>Rating</th>
			<th>Action</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${songs}" var="song">
		<tr>
			<td><a href="/songs/${song.id}">${song.title}</td>
			<td>${song.rating}</td>
			<td><a href="/delete/${song.id}">Delete</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>