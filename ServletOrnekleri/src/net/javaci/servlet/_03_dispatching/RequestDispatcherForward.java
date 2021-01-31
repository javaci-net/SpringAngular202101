package net.javaci.servlet._03_dispatching;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispatcherInclude
 */
@WebServlet("/RequestDispatcherForward")
public class RequestDispatcherForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Before forward at: ").append(request.getServletPath());
		
		RequestDispatcher requestDispatcherHeader = request.getRequestDispatcher("/ServelShareData");
		// RequestDispatcher requestDispatcherHeader = request.getRequestDispatcher("http://www.javaci.net");
		
		requestDispatcherHeader.forward(request, response);
		
		response.getWriter().append("After forwatd at: ").append(request.getServletPath());
	}
}
