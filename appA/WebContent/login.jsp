<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SAML Source Site Application Login Page</title>
</head>
<body style="background-color:#f4d2c9">
<h2>
	Welcome to SAML Source Site Application : appA<br/>
</h2>
<p>
	This example demonstrates how an application can be configured to participate
	in Single Sign-On process. 
</p>
<p>
	SAML Source site application authenticates user. Upon authentication the user
	can access Destination site application without having to login again.
</p>

<h4>Please enter your user name and password to login to SAML Source Site Application, appA:</h4>
<form method="POST" action="j_security_check">
<table border=1>
	<tr>
		<td>Username:</td>
		<td><input type="text" name="j_username"></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" name="j_password"></td>
	</tr>
	<tr>
		<td colspan=2 align=right><input type=submit value="Submit"></td>
	</tr>
</table>
</form>
</body>
</html>
