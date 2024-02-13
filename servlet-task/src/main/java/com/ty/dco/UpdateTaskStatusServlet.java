package com.ty.dco;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.Connection_Task;
import com.ty.dto.Task;

public class UpdateTaskStatusServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		System.out.println("id is : "+id);
		int taskId = Integer.parseInt(id);
	        String newStatus = req.getParameter("status");
	        
	        // Update task status (replace with your logic)
	      
	        Task task = Connection_Task.getTaskById(taskId);
	        if (task != null) {
	        	if(newStatus.equalsIgnoreCase("assigned")) {
	            task.setStatus("completed");
	        	}
	        	else if(newStatus.equalsIgnoreCase("completed")) {
		            task.setStatus("assigned");
		        }
	            Task t= Connection_Task.updateTask(task);
	            
	            if(t!=null) {
//	            	resp.getWriter().write("<html><body>");
//		            resp.getWriter().write("<h3>Task status updated successfully.</h3>");
//		            resp.getWriter().write("</html></body>");
		            
//		            RequestDispatcher dispatch=req.getRequestDispatcher("View_Task_Employee.jsp");
//		            dispatch.include(req, resp);
		            resp.sendRedirect("updateEmployee");
	            }
	            
	        } else {
	            resp.getWriter().write("Task not found or unable to update status.");
	        }
	}

}
