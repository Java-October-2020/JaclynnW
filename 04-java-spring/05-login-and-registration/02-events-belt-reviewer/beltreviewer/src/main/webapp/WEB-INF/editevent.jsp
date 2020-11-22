<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event</title>
</head>
<body>
<div class="container">
<h2>${event.name}</h2>
<hr>
<h3>Edit Event</h3>

<form:form action="/events/edit/${event.id}" method="post" modelAttribute="event">
<form:input type="hidden" value="${user_id}" path="planner"/>
    <div class="form-group">
          <form:label path="name">Name</form:label>
          <form:errors path="name"/>
          <form:input type="text" class="form-control" path="name" />
      </div>
      <div class="form-group">
          <form:label path="date">Date</form:label>
          <form:errors path="date"/>
          <form:input type="date" class="form-control" path="date" />
      </div>
      <div class="form-group">
          <form:label path="location">Location</form:label>
          <form:errors path="location"/>
          <form:input type="text" path="location" />
      	  <form:label path="state">State</form:label>
          <form:errors path="state"/>
          <form:input type="text" path="state" />
      </div>
      <button>Submit</button>


</form:form>


</div>
</body>
</html>