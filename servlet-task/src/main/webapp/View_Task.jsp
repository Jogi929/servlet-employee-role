<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
   <%@ page import="com.ty.dao.Connection_User" %>
   <%@ page import="com.ty.dto.Users" %>
   <%@ page import="com.ty.dto.Task" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
List<Users> employee_list=Connection_User.assignUser();
%>

<% for (Users employee : employee_list) {
	List<Task>  task_list=employee.getTasks();       
  %>
  
	<%for(Task task:task_list){%>
	<h3>Task Id is:<%=task.getTask_id() %></h3>
	<h3>Task Description is:<%=task.getDescription() %></h3>
	<h3>Task status is:<%=task.getStatus() %></h3>
	<h3>Task Assigned to :<%=employee.getEmail() %></h3>
	<h3>Task is doing by :<%=employee.getName() %></h3>
	<h3>----------------------------------</h3>
        <% } %>
        <%} %>
       
  <a href="logout"><button>Log Out</button></a>

</body>
</html>