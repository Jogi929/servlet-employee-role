package com.ty.dco;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.Connection_Task;

@WebServlet("/task_assign")
public class User_Assign_Task extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String task_description=req.getParameter("task_description");
		String employee_assigned=req.getParameter("employee_assigned");
		String task_status=req.getParameter("task_status");
		
		PrintWriter print_write=resp.getWriter();
		
		if(Connection_Task.registerTask(task_description,employee_assigned,task_status)!=null) {
			print_write.print("<html><body>");
			print_write.print("<h2>Assigned sucessfully</h2>");
			print_write.print("<html");
		}else {
			
			print_write.print("<h2>Not Assigned Sucessfully</h2>");
			
			//including the task page
			RequestDispatcher dispatch=req.getRequestDispatcher("Assign_task.jsp");
			dispatch.include(req, resp);
		}
		
		
		
	}

}
