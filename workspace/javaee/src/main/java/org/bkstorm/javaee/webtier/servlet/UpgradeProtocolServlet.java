package org.bkstorm.javaee.webtier.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bkstorm.javaee.webtier.servlet.handler.XYZPUpgradeHandler;

@WebServlet(urlPatterns = "/upgradeProtocol")
public class UpgradeProtocolServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3718185068720592704L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("XYZ".equals(request.getHeader("Upgrade"))) {
			/* Accept upgrade request */
			response.setStatus(101);
			response.setHeader("Upgrade", "XYZP");
			response.setHeader("Connection", "Upgrade");
			response.setHeader("OtherHeaderB", "Value");
			/* Delegate the connection to the upgrade handler */
			XYZPUpgradeHandler xyzpHandler = request.upgrade(XYZPUpgradeHandler.class);
			/* (the service method returns immedately) */
		}
	}

}
