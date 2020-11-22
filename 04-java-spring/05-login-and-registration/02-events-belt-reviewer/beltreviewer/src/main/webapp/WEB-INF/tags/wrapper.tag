<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<html>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All The Coolest Ideas</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<div class ="container">
<h1>Welcome ${user.firstName} ${user.lastName}</h1>
<a href="/ideas/new">Got a new idea?</a> | <a href="/logout">Log Out</a>
<hr>
	<jsp:doBody/>
</div>
</body>
</html>