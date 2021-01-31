package net.javaci.servlet._09_filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CatchAllRequestFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, 
		urlPatterns = { 
				"/*", 
				"/aaaa"
		}, 
		servletNames = { "GetAttributesServlet" })
public class CatchAllRequestFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("CatchAllRequestFilter catch the request for " + ((HttpServletRequest)request).getServletPath());
		
		// response.getWriter().append("Merhaba");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
