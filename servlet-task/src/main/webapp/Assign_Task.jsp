<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.List" %>
   <%@ page import="com.ty.dao.Connection_User" %>
   <%@ page import="com.ty.dto.Users" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Page</title>
</head>
<body>

<h1>Task Assign To the Employee</h1>

<%
List<Users> user_list=Connection_User.assignUser();
%>

<form action="task_assign" method="post">

	Task Description<input type="text" name="task_description">
	<br><br><br>
	Assign To<select name="employee_assigned" id="dropdown">
        <% for (Users user : user_list) { %>
            <option value="<%= user.getEmail() %>"><%= user.getEmail() %></option>
        <% } %>
    </select>
  <br><br><br>
  Status<input type="text" name="task_status" value="assigned">
  <br><br><br>
  <input type="submit"  value="Add Task">
  <br><br><br>
</form>


</body>
</html>