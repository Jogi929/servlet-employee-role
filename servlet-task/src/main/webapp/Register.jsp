<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>

<h1>Register Page</h1>
<form action="register" method="post">

Name<input type="text" name="user_name">
<br><br><br>
Email<input type="text" name="user_email">
<br><br><br>
Password<input type="password" name="user_password">
<br><br><br>
<!-- Dropdown list -->
Role<select id="Role" name="user_role">
  <option value="Manager">Manager</option>
  <option value="Employee">Employee</option>
</select>
<br><br><br>
Designation<input type="text" name="user_designation">
<br><br><br>
Salary<input type="text" name="user_salary">
<br><br><br>
<input type="submit" value="Register">

</form>

</body>
</html>