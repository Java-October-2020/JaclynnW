<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h3><a href="/dashboard" class="float-right">Dashboard</a></h3>
<h4>Title:</h4>
<p>${song.title}</p>
<h4>Artist</h4>
<p>${song.artist}</p>
<h4>Rating (1-10)</h4>
<p>${song.rating}</p>
<p></p>



<a href="/delete/${song.id}" class="btn btn-danger">Delete</a>

</div>
</body>
</html>