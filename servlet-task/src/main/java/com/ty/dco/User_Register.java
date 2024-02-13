package com.ty.dco;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.Connection_User;

@WebServlet("/register")
public class User_Register extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("user_name");
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		String role=req.getParameter("user_role");
		String designation=req.getParameter("user_designation");
		String salary=req.getParameter("user_salary");
		
		PrintWriter print_write=resp.getWriter();
		
		if(Connection_User.registerUser(name,email,password,role,designation,salary)!=null) {
			
			print_write.print("<html><body>");
			print_write.print("<h2>Registered Sucessfully</h2>");
			print_write.print("</html></body>");
			
			//including the login page
			RequestDispatcher dispatch=req.getRequestDispatcher("Login.jsp");
			dispatch.include(req, resp);
			
		}else {
			print_write.print("<h2>Error Occurs.....Register Again</h2>");
			
			//including the login page
			RequestDispatcher dispatch=req.getRequestDispatcher("Login.jsp");
			dispatch.include(req, resp);
		}
		
	}

}
