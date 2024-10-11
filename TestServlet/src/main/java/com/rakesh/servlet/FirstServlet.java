package com.rakesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet{
ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("creating object....");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Servicing............");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>this is my output from servlet method:</h1>");
		out.println("<h1>Today date and time is"+new Date().toString()+"</h1>");
	}

	@Override
	public void destroy() {
		System.out.println("going to destory servlet object");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		return "This servlet created by Rakesh Jain";
	}


	
}
