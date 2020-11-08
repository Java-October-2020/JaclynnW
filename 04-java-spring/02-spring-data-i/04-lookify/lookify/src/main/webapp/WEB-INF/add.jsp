<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a New Song</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<div class="container">
<c:forEach items="${errors}" var="err">
<p>${err}</p>
</c:forEach>

<form:form method="Post" action="/songs/new" modelAttribute="song">
	<div class="form-group">
	<form:label path="title">Song Title:
	<form:errors path="title"/>
	<form:input path="title"/></form:label>
	</div>
	<div class="form-group">
	<form:label path="artist">Artist:
	<form:errors path="artist"/>
	<form:input path="artist"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="rating">Rating (1-10):
	<form:errors path="rating"/>
	<form:input path="rating"/></form:label>
	</div>
	<button>Add Song</button>
</form:form>
</div>
</body>
</html>