package net.javaci.servlet._11_configContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleHttpServlet
 */
@WebServlet("/ServletContextExampleServlet")
public class ServletContextExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getServletPath());

		// creating ServletContext object
		ServletContext context = getServletContext();

		String contexParam1 = context.getInitParameter("contexParam1");
		
		response.getWriter().append(" contexParam1 from web.xml: ").append(contexParam1);
		
		// Enumeration getInitParameterNames()
	}

}