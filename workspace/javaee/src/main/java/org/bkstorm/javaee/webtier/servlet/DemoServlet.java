package org.bkstorm.javaee.webtier.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

@WebServlet("/report")
public class DemoServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 4788664655423816094L;
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		request.setAttribute("author", "hoangnv");

		response.setContentType(MediaType.TEXT_PLAIN);
		PrintWriter writer = response.getWriter();
		writer.write("Context Path: " + request.getContextPath() + "\n");
		writer.write("Request URI: " + request.getRequestURI() + "\n");
		writer.write("Path info: " + request.getPathInfo() + "\n");
	}
}
