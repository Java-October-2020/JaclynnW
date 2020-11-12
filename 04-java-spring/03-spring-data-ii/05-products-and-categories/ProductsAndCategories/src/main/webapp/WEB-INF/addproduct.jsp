<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
<title>Add a New Product</title>
</head>
<body>
<h1>New Product</h1>
<form:form method="Post" action="/products/new" modelAttribute="product">
	<div class="form-group">
	<form:label path="name">Name:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="description">Description:
	<form:errors path="description"/>
	<form:input path="description"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="price">Price:
	<form:errors path="price"/>
	<form:input path="price"/></form:label>
	</div>
	<button>Create</button>
</form:form>
</div>

</body>
</html>