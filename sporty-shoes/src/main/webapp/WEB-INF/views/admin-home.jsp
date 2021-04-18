<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	</head>

<body>

	
	<div>
	<h1>Welcome ${admin.getFirstName() },${admin.getLastName() }</h1>
	
	<a style="float: right;" href="loggingout">Log Out</a>
	</div>
	<br/><br/><br/><br/>
	<div align="center">
		<div>Want to change Password <a href="changePassword">click here</a>.</div>
		<div>Want to Manage Products <a href="products">click here</a>.</div>
		<div>Want to See Users <a href="usersView">click here</a>.</div>
		<div>Want to see Orders <a href="orders">click here</a>.</div>
	</div>
</body>

</html>


