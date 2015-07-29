package org.bkstorm.javaee.webtier.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/asyncIO", asyncSupported = true)
public class AsyncIOServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 419404662472244574L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final AsyncContext asyncCtx = request.getAsyncContext();
		final ServletInputStream inputStream = request.getInputStream();

		inputStream.setReadListener(new ReadListener() {
			byte[] buffer = new byte[4 * 1024];
			StringBuilder sbuilder = new StringBuilder();

			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub

			}

			public void onDataAvailable() throws IOException {
				try {
					do {
						int length = inputStream.read(buffer);
						sbuilder.append(new String(buffer, 0, length));
					} while (inputStream.isReady());
				} catch (IOException e) {

				}
			}

			public void onAllDataRead() throws IOException {
				try {
					asyncCtx.getResponse().getWriter().write("... the response ...");
				} catch (IOException e) {

				}
				asyncCtx.complete();
			}
		});
	}

}
