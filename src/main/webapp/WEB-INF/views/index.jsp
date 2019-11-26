<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp"
	crossorigin="anonymous">
</head>
<body>

	<h1>Login</h1>
	<form action="login">
		${msg }
		Email address: <input type="text" name="email"><br>
		Password: <input type="password" name="password"><br> 
		<input class="btn btn-primary" type="submit" value="Submit">
	</form>
	
	<a href="/createNewAccount" class="btn btn-primary">Create new account</a>
</body>
</html>