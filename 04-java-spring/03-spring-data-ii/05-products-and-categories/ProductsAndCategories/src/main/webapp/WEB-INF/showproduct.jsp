<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Categories</title>
</head>
<body>
<h1>${product.name}</h1>
<p>${product.description}</p>
<h2>Categories:</h2>
<ul>
<c:forEach items="${cat}" var="productCategory">
<li>${productCategory.name}</li>
</c:forEach>
</ul>
<hr>
<h4>Add Category</h4>
<form:form action="/product/{id}" method="Post" modelAttribute="categories">
<form:input type="hidden" path="product" value="${product_id}"/>
<div class="form-group">
	<form:label path="category">Category</form:label>
	<form:errors path="category"/>
	<form:select class="form-control" path="category">
	<c:forEach items="${notUsedCategories}" var="possibleCat">
		<option value=${possibleCat.id}>${possibleCat.name}</option>
	</c:forEach>
	</form:select>
</div>
<button>Add</button>
</form:form>
</body>
</html>