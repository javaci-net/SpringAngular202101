package net.javaci.servlet._09_filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FirstFilter
 */
@WebFilter(filterName = "FirstFilter", urlPatterns = "/order/*")
public class FirstFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("FirstFilter catch the request for " + ((HttpServletRequest)request).getServletPath());
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}


}
