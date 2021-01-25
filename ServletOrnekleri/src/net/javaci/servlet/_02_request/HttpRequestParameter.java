package net.javaci.servlet._02_request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpRequestParameter
 */
@WebServlet("/HttpRequestParameter")
public class HttpRequestParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		response.getWriter().append("Served at: ").append(request.getServletPath())
				.append(" with name = ").append(name)
				.append(" and surname = ").append(surname);
		
		Enumeration<String> parameters = request.getParameterNames();
		while(parameters.hasMoreElements()) {
			String parameterName = parameters.nextElement();
			System.out.println(parameterName + " = " + request.getParameter(parameterName));;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
