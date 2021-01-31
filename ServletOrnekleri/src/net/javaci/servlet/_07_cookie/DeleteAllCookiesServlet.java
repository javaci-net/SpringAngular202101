package net.javaci.servlet._07_cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteAllCookiesServlet")
public class DeleteAllCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		Cookie[] cookies = request.getCookies();
		
		if (cookies == null) {
			response.getWriter().append("<h1>There is no cookies</h1>");
			return;
		}
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
			}
		}
		
		response.getWriter().append("<h1>" + cookies.length + " cookies were deleted</h1>");
		

	}

}
