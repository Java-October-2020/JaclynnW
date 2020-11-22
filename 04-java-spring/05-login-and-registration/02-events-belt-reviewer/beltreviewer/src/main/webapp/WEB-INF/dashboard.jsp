<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1> Welcome ${user.firstName}</h1>
<p class="float-right"><a href="/logout">Log Out</a></p>


<h3>Here are some events in your state:</h3>
<table class="table table-dark">
	<thead>
	<th>Event Name</th>
	<th>Date</th>
	<th>Location</th>
	<th>Host</th>
	<th>Action/Status</th>
	</thead>
	<tbody>
	<c:forEach items="${usersStates}" var="event">
	<tr>
		<td><a href="/events/${event.id}">${event.name}</a>
		<td><fmt:formatDate value="${event.date}" pattern="MMMM dd, yyyy"/></td>
		<td>${event.location}, ${event.state }</td>
		<td>${event.planner.firstName}</td>
		<c:choose>
			<c:when test="${event.planner.id == user.id}">
				<td><a href="/events/edit/${event.id}">Edit</a> | <a href="/events/delete/${event.id}">Delete</a></td>
			</c:when>
			<c:when test="${event.guests.contains(user)}">
				<td><a href="/events/unrsvp/${event.id}">Cancel</a></td>
			</c:when>
			<c:otherwise>
				<td><a href="/events/rsvp/${event.id}">Join</a></td>
			</c:otherwise>
		</c:choose>
	</tr>
	</c:forEach>
	</tbody>
</table>

<h3>Here are some events in other states:</h3>
<table class="table table-dark">
	<thead>
	<th>Event Name</th>
	<th>Date</th>
	<th>Location</th>
	<th>Host</th>
	<th>Action/Status</th>
	</thead>
	<tbody>
	<c:forEach items="${otherStates}" var="event">
	<tr>
		<td><a href="/events/${event.id}">${event.name}</a>
		<td><fmt:formatDate value="${event.date}" pattern="MMMM dd, yyyy"/></td>
		<td>${event.location}, ${event.state}</td>
		<td>${event.planner.firstName}</td>
		<c:choose>
			<c:when test="${event.planner.id == user.id}">
				<td><a href="/events/edit/${event.id}">Edit</a> | <a href="/events/delete/${event.id}">Delete</a></td>
			</c:when>
			<c:when test="${event.guests.contains(user)}">
				<td><a href="/events/unrsvp/${event.id}">Cancel</a></td>
			</c:when>
			<c:otherwise>
				<td><a href="/events/rsvp/${event.id}">Join</a></td>
			</c:otherwise>
		</c:choose>
	</tr>
	</c:forEach>
	</tbody>
</table>

<h3>Create an Event</h3>
<form:form method="Post" action="/events/new" modelAttribute="event">
	<div class="form-group">
		<form:label path="name">Name:
		<form:errors path="name"/>
		<form:input path="name"/></form:label>
	</div>
	<div class="form-group">
		<form:label path="date">Date:</form:label>
		<form:errors path="date"/>
		<form:input type="date" path="date"/>
	</div>
	<div class="form-group">
		<form:label path="location">Location:
		<form:errors path="location"/>
		<form:input path="location"/></form:label>
		<form:label path="state">State:
		<form:errors path="state"/>
		<form:input path="state"/></form:label>
	</div>
	<input type="submit" value="Create Event"/>
	</form:form>
	

</div>
</body>
</html>