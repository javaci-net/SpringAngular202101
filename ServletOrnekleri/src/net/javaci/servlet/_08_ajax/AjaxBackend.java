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
@WebServlet("/AjaxBackend")
public class AjaxBackend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxHandler(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxHandler(request, response, "POST");
	}

	private void ajaxHandler(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
		String query = request.getParameter("query");
		System.out.println(method + " cagrisi yapildi. query degeri = " + query);
		
		if (query == null || query == "") {
			response.getWriter().append("(" + method + ")");
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			response.getWriter().append(query + i + " ");
		}
		response.getWriter().append("(" + method + ")");
	}

}
