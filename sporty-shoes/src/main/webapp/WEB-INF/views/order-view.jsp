<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.simplilearn.workshop.model.*,java.util.*" %>

<html>
	<head>
		<title>Orders</title>
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
	<body>
		<h3>List of Orders</h3>
		<br/>
		<h4><a href="log">Click here</a> for Home</h4>
		<br/>
		<form align="center" action="filterSearch" method="POST">
			<div>
				<label>Filer by :- </label>
				<div>
				<label>Date:-</label>
				<input type="date" name="date" value="" max="<%=LocalDate.now() %>">
				</div>
				<br/>
				<div>
					<label>Category</label>
					<select name="category">
						<option value=""></option>
						<c:forEach var="temp" items="${set }">
							<option value="${temp }">${temp }</option>
						</c:forEach>
					</select>
				</div>
				<br/>
				<input type="submit" value="submit"/>
			</div>
		</form>
		
		<br/>
		<c:if var="tem" test="${orders != null && orders.size() > 0 }">
		<table align="center">
		<tr>
			<th>S.No.</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>User Name</th>
			<th>Email</th>
			<th>Category</th>
			<th>Company</th>
			<th>Price</th>
			<th>Date of Order</th>
		</tr>
		<% int i = 1; %>
		<c:forEach var="temp" items="${orders }">
			<tr>
				<td><%=i++ %></td>
				<td>${temp.getUser().getFirstName() }</td>
				<td>${temp.getUser().getLastName() }</td>
				<td>${temp.getUser().getUserName() }</td>
				<td>${temp.getUser().getEmail()}</td>
				<td>${temp.getProduct().getCategory() }</td>
				<td>${temp.getProduct().getCompany() }</td>
				<td>${temp.getProduct().getPrice() }</td>
				<td>${temp.getOrderDetails().getDate() }</td>
			</tr>
		</c:forEach>
		</table>
		</c:if>
		<c:if test="${!tem }">
			<h4 align="center" style="color: red;">Sorry no Order available.</h4>
		</c:if>
	</body>
</html>