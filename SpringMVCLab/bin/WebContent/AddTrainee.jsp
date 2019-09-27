<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="a" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Enter Trainee Details</h2>
	<a:form action="added" method="post" modelAttribute="trn">
		<table>
			<tr>
				<td>Trainee Id</td>
				<td><a:input path="traineeId" /></td>
			</tr>
			<tr>
				<td>Trainee Name</td>
				<td><a:input path="traineeName" /></td>
			</tr>
			<tr>
				<td>Trainee Location</td>
				<td><a:radiobutton path="traineeLocation" value="Chennai"/>Chennai</td>
				<td><a:radiobutton path="traineeLocation" value="Bangalore"/>Bangalore</td>
				<td><a:radiobutton path="traineeLocation" value="Pune"/>Pune</td>
				<td><a:radiobutton path="traineeLocation" value="Mumbai"/>Mumbai</td>
			</tr>
			<tr>
				<td>Trainee Domain</td>
				<td><a:select path="traineeDomain">
					<a:option value="Please Select"></a:option>
					<a:option value="Java"></a:option>
					<a:option value="Python"></a:option>
					<a:option value="Oracle"></a:option>
				</a:select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Trainee"/></td>
			</tr>
		</table>
	</a:form>
</body>
</html>