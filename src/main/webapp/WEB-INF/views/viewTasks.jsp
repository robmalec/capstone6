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
<h1>Tasks:</h1>
<table>
<tr>
<th>Description</th>
<th>Due date</th>
<th>Completed?</th>
</tr>
<c:forEach var = "t" items="${tasks }">
<tr>
<th>${t.description }</th>
<th>${t.getCalString() }</th>
<th>${t.complete }</th>
<th><a href="/startUpdateForm" class="btn btn-primary">Update task</a></th>
</tr>
</c:forEach>
</table>

</body>
</html>