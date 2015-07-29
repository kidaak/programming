package org.bkstorm.javaee.webtier.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4698528839856334417L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(MediaType.TEXT_PLAIN);
		final AsyncContext asyncContext = request.startAsync();
		asyncContext.start(new Runnable() {
			public void run() {
				HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
				try {
					PrintWriter writer = response.getWriter();
					writer.println("Hello, I'm a asynchronous servlet");
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					asyncContext.complete();
				}
			}
		});
	}

}
