package org.bkstorm.javaee.webtier.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "Demo Filter", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "author", value = "hoangnv") }, asyncSupported = true)
public class DemoFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub+
		if (response instanceof HttpServletResponse) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.addHeader("author", "hoangnv");
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
