package net.javaci.servlet._04_scopes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeInServlet
 */
@WebServlet("/ScopeInServlet")
public class ScopeInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet is initialized");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer requestValue = (Integer) request.getAttribute("requestValue");
		if (requestValue != null)
			requestValue++;
		else
			requestValue = 0;
		request.setAttribute("requestValue", requestValue);

		
		HttpSession session = request.getSession();
		Integer sessionValue = (Integer) session.getAttribute("sessionValue");
		if (sessionValue != null)
			sessionValue++;
		else
			sessionValue = 0;
		session.setAttribute("sessionValue", sessionValue);

		
		
		Integer applicationValue = (Integer) request.getServletContext().getAttribute("applicationValue");
		if (applicationValue != null)
			applicationValue++;
		else
			applicationValue = 0;
		request.getServletContext().setAttribute("applicationValue", applicationValue);

		// print response
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<p>requestScope: " + requestValue + "</p>");
		out.write("<p>sessionScope: " + sessionValue + "</p>");
		out.write("<p>applicationScope: " + applicationValue + "</p>");
		out.write("</body></html>");
	}
}