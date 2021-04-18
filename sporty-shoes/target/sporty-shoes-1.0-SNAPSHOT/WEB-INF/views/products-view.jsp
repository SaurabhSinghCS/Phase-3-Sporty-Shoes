<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Products List</title>
		
		<!-- refer our style sheet -->
<%-- 		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"> --%>
	</head>
	
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Products</h2>
			</div>
		</div>
		<br/>
		<h4><a href="log">Click here</a> for Home</h4>
		<br/>
		<div id="container">
			<div id="context">
			
			
			<input type="button" value="Add Product"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			
			
				<!-- html table -->
				<c:if var="ifTemp" test="${products!=null && products.size()>0 }">
				<table>
					<tr>
						<th>S.No.</th>
						<th>Company</th>
						<th>Category</th>
						<th>Price</th>
					</tr>
					<% int i=1; %>
				<c:forEach var="temp" items="${products}">
				
					<!-- construct a "update" link with product id -->
					<c:url var="updateLink" value="showFormForUpdate">
						<c:param name="productId" value="${temp.id}" />
					</c:url>					

					<!-- construct a "delete" link with product id -->
					<c:url var="deleteLink" value="delete">
						<c:param name="productId" value="${temp.id}" />
					</c:url>	
					
					<tr>
						<td><%=i++ %></td>
						<td>${temp.getCompany() }</td>
						<td>${temp.getCategory() }</td>
						<td>${temp.getPrice() }</td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this Product?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
				</table>
				</c:if>
				<c:if test="${!ifTemp }">
					<h3 align="center" style="color: red;">Sorry no Order available.</h3>
				</c:if>
			</div>
		</div>
	</body>
</html>