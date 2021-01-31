package net.javaci.servlet._08_ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxBackend
 */
@WebServlet("/AjaxBootstrapAutocomplateBackend")
public class AjaxBootstrapAutocomplateBackend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxHandler(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxHandler(request, response, "POST");
	}

	private void ajaxHandler(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
		String query = request.getParameter("q");
		System.out.println(method + " cagrisi yapildi. query degeri = " + query);
		
		response.getWriter().append("[\r\n");
		for (int i = 0; i < 3; i++) {
			if (i != 2)
				response.getWriter().append("	\"" + (query + i) + "\",\r\n");
			else 
				response.getWriter().append("	\"" + (query + i) + "\"\r\n");
		}
		response.getWriter().append("]");
		response.setContentType("application/json" );
	}

}
