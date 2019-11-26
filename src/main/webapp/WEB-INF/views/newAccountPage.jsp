<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp" crossorigin="anonymous">
</head>
<body>
<h1>Welcome to the Task Manager!</h1>
<h2>Please enter some personal information below:</h2>
<form action="addAccount" method="POST">
Email address:<input type="email" name="email" required>
Password:<input type="password" name="pswd" required>
<input type="submit" class="btn btn-primary" value="Submit">
</form>


</body>
</html>