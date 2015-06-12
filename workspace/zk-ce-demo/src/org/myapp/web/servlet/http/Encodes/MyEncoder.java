package org.myapp.web.servlet.http.Encodes;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.zkoss.web.servlet.http.Encodes.URLEncoder;

public class MyEncoder implements URLEncoder {

	@Override
	public String encodeURL(ServletContext ctx, ServletRequest request,
			ServletResponse response, String uri, URLEncoder defaultEncoder)
			throws Exception {
		if (isStaticResource(uri)) {
			return getResourceHost() + uri.replace("~./", "");
		} else {
			return defaultEncoder.encodeURL(ctx, request, response, uri,
					defaultEncoder);
		}
	}

	/**
	 * file .wcs : CSS File file .wpd : Javscript File
	 */
	private boolean isStaticResource(String url) {
		// zul.lang.wpd should not be a static resource
		return url.startsWith("~./") && !url.endsWith("zul.lang.wpd")
				&& (url.endsWith(".wpd") || url.endsWith(".wcs"));
	}

	/**
	 * Detect where the ip is/ who is login / what kind of resouce server will
	 * 
	 * @return the host name include protocol prefix. (Client will retrieve
	 *         resource from it)
	 */
	private String getResourceHost() {
		return "http://127.0.0.1/";
	}

}
