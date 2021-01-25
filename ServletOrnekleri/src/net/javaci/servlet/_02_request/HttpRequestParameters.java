package net.javaci.servlet._02_request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpRequestParameter
 */
@WebServlet("/HttpRequestParameters")
public class HttpRequestParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Should not come here with get ").append(request.getServletPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");

		PrintWriter out = response.getWriter();
		out.append("<html>");
		out.append("<body>");
		
		out.append("Served at: ").append(request.getServletPath()).append("<br>");
		out.append(" with name = ").append(name).append("<br>");
		out.append(" and surname = ").append(surname).append("<br>");
		
		String[] values = request.getParameterValues("language");
		for (String lang : values) {
			out.append(" language = ").append(lang).append("<br>");
		}
		
		
		out.append("</body>");
		out.append("</html>");
		


		
		
		// ekrana yazdiriyoruz
		Enumeration<String> parameters = request.getParameterNames();
		while (parameters.hasMoreElements()) {
			String parameterName = parameters.nextElement();
			System.out.println(parameterName + " = " + request.getParameter(parameterName));;
		}

		Map<String, String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>> set = map.entrySet();
		for (Entry<String, String[]> entry : set) {
		
			String key = entry.getKey();
			String[] valuesArray = entry.getValue();

			System.out.println("Key is " + key);

			if (valuesArray.length > 1) {
				for (String value : valuesArray) {
					System.out.println(value);
				}
			} else
				System.out.println("Value is " + valuesArray[0]);

			System.out.println("-------------------");
		}

		// request.getParameterMap();
		// request.getParameterValues(name);
	}

}
