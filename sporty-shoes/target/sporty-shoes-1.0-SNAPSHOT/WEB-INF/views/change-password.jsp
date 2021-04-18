<html>
	<head>
		<title>Change Password</title>
	</head>
	<body>
		<h3 align="center">Change Password</h3>
		<br/>
		<h4 align="center"><a href="log">Click here</a> for Home</h4>
		<br/>
		<form action="passwordChange" method="POST">
			<div align="center">
				Enter New Password : <input type="password" name="password1" required="required">
			</div>
			<br/>
			<div align="center">
				Confirm Password : <input type="password" name="password2" required="required">
			</div>
			<br/>
			<div align="center">
				<input type="submit" value="submit">
			</div>
		</form>
	</body>
</html>