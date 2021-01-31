package net.javaci.servlet._06_exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExceptionServlet
 */
@WebServlet("/ExceptionServlet")
public class ExceptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String exceptionType = request.getParameter("exception-type");
		
		if (exceptionType == null)
			throw new IOException("IOException from ExceptionServlet");
		
		if (exceptionType.equals("runtime")) {
			throw new RuntimeException("RuntimeException from ExceptionServlet");
		} else if (exceptionType.equals("custom")) {
			throw new MyCustomException("MyCustomException from ExceptionServlet");
		} else {
			throw new IOException("IOException from ExceptionServlet");
		}
	}
}
