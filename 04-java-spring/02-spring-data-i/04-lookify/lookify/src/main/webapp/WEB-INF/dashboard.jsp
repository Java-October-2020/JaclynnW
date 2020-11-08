<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<h3><a href="/songs/new">Add New</a> <a href="/search/topTen">Top Songs</a></h3>
<form action="/songs/search" class="float-right">
	<input type="text" name="artist"/>
	<button class="btn btn-primary">Search Artist</button>
</form>
<table class="table table-light">
<thead>
	<th>Song Title</th>
	<th>Rating</th>
	<th>Actions</th>
</thead>
<tbody>
	<c:forEach items="${allSongs}" var="song">
	<tr>
	<td><a href="/${song.id}">${song.title}</a></td>
	<td>${song.rating}</td>
	<td><a href="/delete/${song.id}">delete</a></td>
	</tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>