package net.javaci.servlet._09_filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterDefineInWebXml implements Filter {
	
	 public void  init(FilterConfig config) throws ServletException {
	      
	      // Get init parameter 
	      String testParam = config.getInitParameter("test-param"); 

	      //Print the init parameter 
	      System.out.println("Test Param: " + testParam); 
	   }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("FilterDefineInWebXml catch the request for " + ((HttpServletRequest)request).getServletPath());

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
