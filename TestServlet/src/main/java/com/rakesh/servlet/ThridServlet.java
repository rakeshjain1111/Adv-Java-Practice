package com.rakesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThridServlet extends HttpServlet {
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	  System.out.println("This is get Methods.............");
	  res.setContentType("text/html");
	  PrintWriter out = res.getWriter();
	  out.print("<h1>This is get Method of HttpServlet</h1>");
  }
}
