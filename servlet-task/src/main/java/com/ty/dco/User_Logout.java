package com.ty.dco;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class User_Logout extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session= req.getSession();
		session.invalidate();
		
		resp.getWriter().write("<body><html>");
		resp.getWriter().write("Log out successfully");
		resp.getWriter().write("</body></html>");
		
		RequestDispatcher dispatch=req.getRequestDispatcher("Login.jsp");
		dispatch.include(req, resp);
		
	}
}
