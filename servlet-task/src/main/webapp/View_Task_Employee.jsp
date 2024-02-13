<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Collections"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
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
Users user=(Users)request.getAttribute("updateEmployee");
PrintWriter printer=response.getWriter();
printer.println("<h1>Task Details</h1>");
%>

<%
Comparator<Task> statusComparator = new Comparator<Task>() {
    @Override
    public int compare(Task task1, Task task2) {
        return task1.getStatus().compareTo(task2.getStatus());
    }
};
%>

<%
List<Task> task_list=user.getTasks();
Collections.sort(task_list, statusComparator);
for(Task task:task_list){
%>
<div>
        <p><b>Task ID:</b> <%= task.getTask_id() %></p>
        <p><b>Task Description:</b> <%= task.getDescription() %></p>
        <p><b>Status:</b> <%= task.getStatus() %></p>
        <form action="UpdateTaskStatusServlet" method="post">
        <input type="hidden" value="<%= task.getStatus() %>" name="status">
        <input type="hidden" value="<%= task.getTask_id() %>" name="id">
        <input type="submit" value="Update Task Status">
        </form>
    </div>
<%
}
%>

<a href="logout"><button>Log Out</button></a>
</body>
</html>