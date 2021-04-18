<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

<%-- 	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"> --%>
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
	
		<form:form action="saveProduct" modelAttribute="product" method="POST">

			<!-- need to associate this data with Product id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Company:</label></td>
						<td><form:input path="company" /></td>
					</tr>
				
					<tr>
						<td><label>Category:</label></td>
						<td><form:input path="category" /></td>
					</tr>

					<tr>
						<td><label>Price:</label></td>
						<td><form:input path="price" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/admin/products">Back to List</a>
		</p>
	
	</div>

</body>

</html>


