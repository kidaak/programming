package org.bkstorm.javaee.webtier.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tracking")
public class TrackingServiceRequestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5935062193110410448L;
	private int serviceCounter = 0;
	private boolean shuttingDown;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		enteringServiceMethod();
		try {
			super.service(request, response);
		} finally {
			leavingServiceMethod();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for (int i = 0; ((i < Integer.MAX_VALUE) && !isShuttingDown()); i++) {
			uploadFile();
		}
	}

	private void uploadFile() {
		// upload file
	}

	@Override
	public void destroy() {
		/*
		 * Check to see whether there are still service methods /* /* running,
		 * and if there are, tell them to stop.
		 */
		if (numServices() > 0) {
			setShuttingDown(true);
		}
		/* Wait for the service methods to stop. */
		while (numServices() > 0) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
		}
		super.destroy();
	}

	protected synchronized void enteringServiceMethod() {
		serviceCounter++;
	}

	protected synchronized void leavingServiceMethod() {
		serviceCounter--;
	}

	protected synchronized int numServices() {
		return serviceCounter;
	}

	protected synchronized void setShuttingDown(boolean flag) {
		shuttingDown = flag;
	}

	protected synchronized boolean isShuttingDown() {
		return shuttingDown;
	}

}
