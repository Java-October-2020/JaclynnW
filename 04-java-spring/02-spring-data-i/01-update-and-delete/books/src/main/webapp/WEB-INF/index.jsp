<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All The Books</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<h1>All Books</h1>
<table>
	<thead>
		<tr>
			<th>Title</th>
			<th>Description</th>
			<th>Language</th>
			<th>Number of Pages</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
		<tr>
			<td><c:out value="${book.title }"/></td>
			<td><c:out value="${book.description }"/></td>
			<td><c:out value="${book.language }"/></td>
			<td><c:out value="${book.numberOfPages }"/></td>
			<td><a href="/edit/${book.id}">Edit Book</a></td>
			<td><a href="/delete/${loop.index}" class="btn btn-danger">Delete</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/new">New Book</a>
</body>
</html>