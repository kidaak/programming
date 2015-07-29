package org.bkstorm.javaee.webtier.servlet.handler;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.WebConnection;

public class XYZPUpgradeHandler implements HttpUpgradeHandler {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(WebConnection webconnection) {
		try {
			ServletInputStream input = webconnection.getInputStream();
			ServletOutputStream output = webconnection.getOutputStream();
			/* ... implement XYZP using these streams (protocol-specific) ... */
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
