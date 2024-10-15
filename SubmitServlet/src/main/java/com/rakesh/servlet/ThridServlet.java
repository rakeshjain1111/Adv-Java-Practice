package com.rakesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThridServlet extends HttpServlet {
	   public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		    res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.println("<h2>This is Footer Part</h2>");
			
	}
}
