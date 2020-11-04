<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a book</title>
</head>
<body>
<h1>Edit Book</h1>
<form:form action="/edit/${book.id}" method="POST" modelAttribute="book">
    <div class="form-group">
    	<input type="hidden" name="_method" value="put">
        <form:label path="title">Title
        <form:errors path="title"/>
        <form:input path="title"/></form:label>
    </div>
     <div class="form-group">
    	<input type="hidden" name="_method" value="put">
        <form:label path="description">Description
        <form:errors path="description"/>
        <form:textarea path="description"/></form:label>
    </div>
    <div class="form-group">
    	<input type="hidden" name="_method" value="put">
        <form:label path="language">Language
        <form:errors path="language"/>
        <form:input path="language"/></form:label>
    </div>
    <div class="form-group">
    	<input type="hidden" name="_method" value="put">
        <form:label path="numberOfPages">Pages
        <form:errors path="numberOfPages"/>     
        <form:input type="number" path="numberOfPages"/></form:label>
    </div>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>