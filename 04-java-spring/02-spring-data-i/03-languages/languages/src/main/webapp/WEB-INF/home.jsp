<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Programming Languages</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<div class ="container">
<h1>Programming Languages</h1>
<table class="table table-dark">
<thead>
	<th>Language Name</th>
	<th>Creator Name</th>
	<th>Version</th>
	<th>Action</th>
</thead>
<tbody>
<c:forEach items="${allLanguages}" var="language">
<tr>
<td>${language.name}</td>
<td>${language.creator}</td>
<td>${language.version}</td>
<td><a href="/edit/${language.id}">Edit</a> | <a href="/delete/${language.id}">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>



<div class="add form">
<c:forEach items="${errors}" var="err"> 
<p>${err}</p>
</c:forEach>


<p>
<form:form method="Post" action="/" modelAttribute="languages">
	<div class="form-group">
	<form:label path="name">Name:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</div>
	</p>
		<div class="form-group">
	<form:label path="creator">Creator Name:
	<form:errors path="creator"/>
	<form:input path="creator"/></form:label>
	</div>
	<p>
		<div class="form-group">
	<form:label path="version">Version:
	<form:errors path="version"/>
	<form:input path="version"/></form:label>
	</div>
	</p>
	<button>Add Language</button>
</form:form>
</div>
</div> 

</body>
</html>