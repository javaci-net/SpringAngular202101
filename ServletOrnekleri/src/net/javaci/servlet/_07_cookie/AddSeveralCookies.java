package net.javaci.servlet._07_cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddSeveralCookies")
public class AddSeveralCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Cookie defaultCookie = new Cookie("defaultCookie", "defaultCookie-value");
		response.addCookie(defaultCookie);
		
		Cookie nonPersisteCookie = new Cookie("nonPersisteCookie", "nonPersisteCookie-value");
		nonPersisteCookie.setMaxAge(-1);
		response.addCookie(nonPersisteCookie);

		Cookie oneMinuteCookie = new Cookie("oneMinuteCookie", "oneMinuteCookie-value");
		oneMinuteCookie.setMaxAge(60);
		response.addCookie(oneMinuteCookie);
		
		Cookie tenMinuteCookie = new Cookie("tenMinuteCookie", "tenMinuteCookie-value");
		tenMinuteCookie.setMaxAge(10 * 60);
		response.addCookie(tenMinuteCookie);
		
		Cookie cookieWithComment = new Cookie("cookieWithComment", "cookieWithComment-value");
		cookieWithComment.setComment("Comment for cookieWithComment");
		response.addCookie(cookieWithComment);
		
		Cookie cookieWithPath = new Cookie("cookieWithPath", "cookieWithPath-value");
		cookieWithPath.setPath("/SimpleServlet/ShowAllCookiesServlet");
		response.addCookie(cookieWithPath);
		
		Cookie cookieWithDomain = new Cookie("cookieWithDomain", "cookieWithDomain-value");
		cookieWithDomain.setDomain("localhost");
		response.addCookie(cookieWithPath);
		

		response.getWriter().append("cookies were added");
	}

}
