<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="a" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Trainee Info</h2>
<a:form action="actualdelete" method="post">
<table>
<tr>
<th>Trainee Id</th>
<th>Trainee Name</th>
<th>Trainee Location</th>
<th>Trainee Domain</th>
</tr>
<tr>
<td>${data.traineeId}</td>
<td>${data.traineeName}</td>
<td>${data.traineeLocation}</td>
<td>${data.traineeDomain}</td>
</tr>
<tr>
<td><input type="submit" value="delete"></td>
</tr>
</table>
</a:form>
</body>
</html>