package net.javaci.servlet._13_ServletVariation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletImpl implements Servlet {
	
	int i;

	ServletConfig config = null;

	@Override
	public void destroy() {
		System.out.println("ServletImpl is destroyed");
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "copyright 2007-1010";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("servlet is initialized");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		i++;

		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("<b>hello from ServletImpl " + i + "</b>");
		out.print("</body></html>");

	}

}
