<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>What is the code?</p>
<form method="post" action="/">
<h3>What is the code?</h3>
<span><c:out value="${errors}"/></span>
<label for="code">Code</label>
<input type="text" name="code">
<button>Try Code</button>
</form>
</body>
</html>