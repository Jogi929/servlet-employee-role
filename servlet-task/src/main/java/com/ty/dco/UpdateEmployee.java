package com.ty.dco;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.Connection_Task;
import com.ty.dao.Connection_User;
import com.ty.dto.Profile;
import com.ty.dto.Task;
import com.ty.dto.Users;

@WebServlet("/updateEmployee")
public class UpdateEmployee extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		Users employee = (Users) session.getAttribute("valid_user");
		
//		System.out.println(employee);
//		
//		Profile profile = new Profile(employee.getEmail(), employee.getPassword());
//		System.out.println("hii");
//		employee = Connection_User.getUser(profile);
		
		List<Task> updatedTaskList = Connection_Task.updatedTaskList(employee);
		employee.setTasks(updatedTaskList);
		req.setAttribute("updateEmployee", employee);
		
		System.out.println(employee);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("View_Task_Employee.jsp");
		dispatcher.forward(req, resp);

		
		
	}

}
