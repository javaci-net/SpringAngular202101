package net.javaci.servlet._07_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowAllCookiesServlet")
public class ShowAllCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.append("<html>");
		out.append("<body>");
		
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			out.append("<h1>There is no cookies</h1>");
			out.append("</body>");
			out.append("</html>");
			return;
		}
		
		for (Cookie cookie : cookies) {
			out.append("getName: ").append(cookie.getName()).append("<br>");
			out.append("getValue: ").append(cookie.getValue()).append("<br>");
			out.append("getDomain: ").append(cookie.getDomain()).append("<br>");
			out.append("getPath: ").append(cookie.getPath()).append("<br>");
			out.append("getMaxAge: ").append(cookie.getMaxAge() + "").append("<br>");
			out.append("getComment: ").append(cookie.getComment()).append("<br>");
			out.append("getSecure: ").append(cookie.getSecure() + "").append("<br>");
			out.append("getVersion: ").append(cookie.getVersion() + "").append("<br>");
			out.append("<br><br>");
		}
			

		out.append("</body>");
		out.append("</html>");
	}

}
