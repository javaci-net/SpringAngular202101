package net.javaci.thymleafExamples._03_scope;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@WebFilter("/*")
public class ScopeDataFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Integer requestValue = (Integer) request.getAttribute("requestValue");
		if (requestValue != null)
			requestValue++;
		else
			requestValue = 0;
		request.setAttribute("requestValue", requestValue);
				
		HttpSession session = ((HttpServletRequest) request).getSession();
		Integer sessionValue = (Integer) session.getAttribute("sessionValue");
		if (sessionValue != null)
			sessionValue++;
		else
			sessionValue = 0;
		session.setAttribute("sessionValue", sessionValue);

		
		ServletContext applicationContext = request.getServletContext();
		Integer applicationValue = (Integer) applicationContext.getAttribute("applicationValue");
		if (applicationValue != null)
			applicationValue++;
		else
			applicationValue = 0;
		request.getServletContext().setAttribute("applicationValue", applicationValue);

		System.out.println("ScopeDataFilter executed");
		
		chain.doFilter(request, response);
	}

}
