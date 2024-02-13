package com.ty.dco;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.Connection_User;
import com.ty.dto.Users;

@WebServlet("/login")
public class User_Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		
		HttpSession session=req.getSession();
		if(Connection_User.valid_User(email,password)!=null &Connection_User.valid_User(email,password).getRole().equals("Manager")) {
			
			//setting the user object to the session
			session.setAttribute("valid_user",Connection_User.valid_User(email,password));
			
			//forwarding the request to Manger page
			RequestDispatcher dispatch=req.getRequestDispatcher("Manager.jsp");
			dispatch.forward(req, resp);
			
		}else if(Connection_User.valid_User(email,password)!=null &Connection_User.valid_User(email,password).getRole().equals("Employee")) {
			
			Users user=Connection_User.valid_User(email,password);
			//setting the user object to the session
			session.setAttribute("valid_user",user);
			
			//forwarding the request to Manger page
			RequestDispatcher dispatch=req.getRequestDispatcher("Employee.jsp");
			dispatch.forward(req, resp);
			
		}else {
			
			PrintWriter print_write=resp.getWriter();
			print_write.print("<h2>Email or Password is incorrect</h2>");
			
			//including the login page
			RequestDispatcher dispatch=req.getRequestDispatcher("Login.jsp");
			dispatch.include(req, resp);
			
		}
	}

}
