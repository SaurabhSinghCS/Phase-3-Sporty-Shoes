<%@page import="java.util.regex.Pattern"%>
<%@page import="org.springframework.web.bind.annotation.RequestParam"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.simplilearn.workshop.model.User" %>

<html>
	<head>
		<title>Users</title>
		<style>
			th,td{
				border: 1px solid;
				margin: inherit;
				border-spacing: 0px;
			}
			table {
				border-collapse: collapse;
			}
		</style>
	</head>
	<body align="center">
		<h2>List of Users</h2>
		<br/>
		<h4><a href="log">Click here</a> for Home</h4>
		<br/>
		<form align="center" action="userSearch" method="POST">
			<div>
				<label>Search :- </label>
				<input type="text" name="search" placeholder="Enter First Name or Last Name" size="30px" required="required" />
				<input type="submit" value="submit"/>
			</div>
		</form>
		<br/>
		<c:if var="tem" test="${users != null && users.size()>0 }">
		<table align="center">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>User Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="temp" items="${users }">
			<tr>
				<td>${temp.getFirstName() }</td>
				<td>${temp.getLastName() }</td>
				<td>${temp.getUserName() }</td>
				<td>${temp.getEmail()}</td>
			</tr>
		</c:forEach>
		</table>
		</c:if>
		<c:if test="${!tem }">
			<h4 align="center" style="color: red;">Sorry no user available.</h4>
		</c:if>
	</body>
</html>