package net.javaci.servlet._11_configContext;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigExample
 */
@WebServlet(urlPatterns = { "/ServletConfigExampleParamFromServlet" }, initParams = {
		@WebInitParam(name = "param1", value = "value1"), @WebInitParam(name = "param2", value = "value2") })
public class ServletConfigExampleParamFromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConfigExampleParamFromServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getServletPath());

		String paramFromServlet = getServletConfig().getInitParameter("param1");
		response.getWriter().append(" init param1 from servlet: ").append(paramFromServlet);
		
		paramFromServlet = getServletConfig().getInitParameter("param2");
		response.getWriter().append(" init param2 from servlet: ").append(paramFromServlet);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
