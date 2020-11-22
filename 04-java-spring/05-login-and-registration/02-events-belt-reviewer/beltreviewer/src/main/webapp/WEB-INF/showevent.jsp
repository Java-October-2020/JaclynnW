<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${event.name}</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
</head>
<body>
<div class="container">
<h3>${event.name}</h3>
<p>Host: ${event.planner.firstName} ${event.planner.lastName}</p>
<p>Date: <fmt:formatDate value="${event.date }" pattern="MMMM dd, yyyy"/></p>
<p>Location: ${event.location} ${event.state}</p>
<p>People who are attending this event: ${event.guests.size()}</p>

<table class="table table-dark">
	<thead>
	<th>Guest Name</th>
	<th>Guest Location</th>
	</thead>
	<tbody>
	<c:forEach items="${event.guests}" var="user">
	<tr>
		<td>${user.firstName} ${user.lastName}</td>
		<td>${user.state}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>


<h3>Message Wall</h3>
<div> 
<c:forEach items="${event.comments}" var="comment">
<p>${comment.author.firstName} says: ${comment.message}</p>
</c:forEach>
</div>


<div>
<form method="post" action="/events/comment/${event.id}">
<input type="text" name="message">
<button>Leave a Comment</button>
</form>

</div>
</body>
</html>