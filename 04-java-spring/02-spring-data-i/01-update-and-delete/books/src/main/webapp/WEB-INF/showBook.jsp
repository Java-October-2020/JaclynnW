<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><h3>Title of Book: </h3><c:out value="${book.title}"/></p>
<p><h3>Description of Book: </h3> <c:out value="${book.description}"/></p>
<p><h3>Language of Book: </h3><c:out value="${book.language}"/></p>
<p><h3>Number of pages in Book: </h3><c:out value="${book.numberOfPages}"/></p>
</body>
</html>