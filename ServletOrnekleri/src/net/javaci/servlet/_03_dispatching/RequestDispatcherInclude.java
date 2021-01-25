package net.javaci.servlet._03_dispatching;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispatcherInclude
 */
@WebServlet("/RequestDispatcherInclude")
public class RequestDispatcherInclude extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.append("<html>");
		out.append("<body>");
		
		// Import header
		RequestDispatcher requestDispatcherHeader = request.getRequestDispatcher("/header");
		requestDispatcherHeader.include(request, response);
		
		out.append("Served at: ").append(request.getServletPath()).append("<br>");
		
		// Import footer
		RequestDispatcher requestDispatcherFooter = request.getRequestDispatcher("/footer");
		requestDispatcherFooter.include(request, response);
		
		out.append("</body>");
		out.append("</html>");
	}

}
