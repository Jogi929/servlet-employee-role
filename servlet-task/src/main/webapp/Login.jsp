<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>

</head>
<body>

<h1>Login Page</h1>

<form action="login" method ="post">

Email<input type="text" name="user_email">
<br><br><br>
Password<input type="password" name="user_password">
<br><br><br>
<input type="submit" value="Login">

</form>

<a href="Register.jsp">New User?register</a>
</body>
</html>