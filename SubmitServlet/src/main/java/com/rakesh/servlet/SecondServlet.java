package com.rakesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
   public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	   res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h2>Welcome to Second Servlet</h2>");
		String name =  req.getParameter("name");
		String fname =  req.getParameter("fname");
		String address =  req.getParameter("address");
		String email =  req.getParameter("email");
		String contact =  req.getParameter("contact");
		out.println(name);
		out.println(fname);
		out.println(address);
		out.println(email);
		out.println(contact);
		RequestDispatcher rd = req.getRequestDispatcher("ThridServlet");
		rd.include(req, res);
}
}
