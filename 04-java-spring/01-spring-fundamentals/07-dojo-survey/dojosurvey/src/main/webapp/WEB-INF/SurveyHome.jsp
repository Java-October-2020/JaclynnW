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
<form method="post" action="/">
<label for="name">Your Name: </label>
<input type="text" name ="name">
<label for="dojo">Dojo Location: </label>
<select id="dojo" name="dojo">
<option value="online">Online</option>
<option value="arlington">Arlington</option>
<option value="bellevue">Bellevue</option>
<option value="sanjose">San Jose</option>
</select>
<label for="language">Favorite Language: </label>
<select id="language" name="language">
<option value="java">Java</option>
<option value="mern">Mern</option>
<option value="python">Python</option>
</select>
<label for="comment">Comment (optional)</label>
<input type="text" name="comment">
<button>Button</button>
</form>

</body>
</html>