package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInitParams extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Test init parameters<br>");
		
		java.util.Enumeration e = getServletContext().getInitParameterNames();
		while(e.hasMoreElements()) {
			out.println("param name = " + e.nextElement() + "<br>");
		}
		out.println("main email is " + getServletContext().getInitParameter("mainEmail"));
		out.println("<br>");
		out.println("admin email is " + getServletContext().getInitParameter("adminEmail"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
