package net.javaci.servlet._11_configContext;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigExample
 */
public class ServletConfigExampleParamFromWebXml extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getServletPath());
		
		String param = getServletConfig().getInitParameter("param1");
		response.getWriter().append(" init param1 from web.xml: ").append(param);
		
		param = getServletConfig().getInitParameter("param2");
		response.getWriter().append(" init param2 from web.xml: ").append(param);
	
	}
}
