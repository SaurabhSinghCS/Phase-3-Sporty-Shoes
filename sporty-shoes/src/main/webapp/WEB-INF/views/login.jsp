<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Admin Login</title>
</head>
<body>
<h2 align="center">Welcome to SportyShoes.com</h2>
<br/><br/>

<form:form action="adminLoged" method="POST">
	
	<table>
					<tr>
						<td><label>User name:</label></td>
						<td><input type="text" name="username" required="required" /></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><input type="password" name="password" required="required" /></td>
					</tr>

					<tr>
					<td><input type="reset" value="reset" /></td>
						<td><input type="submit" value="submit" /></td>
					</tr>

				
			</table>
			
</form:form>
</body>
</html>