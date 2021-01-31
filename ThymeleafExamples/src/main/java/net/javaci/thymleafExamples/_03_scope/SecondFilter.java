package net.javaci.thymleafExamples._03_scope;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@WebFilter(filterName = "SecondFilter", urlPatterns = "/*")
public class SecondFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("SecondFilter catch the request for " + ((HttpServletRequest)request).getServletPath());
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}


}