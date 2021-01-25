package net.javaci.servlet._05_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.append("<html>");
		out.append("<body>");
		
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			out.append("request.getSession() ").append("null").append("<br>");
		}
		else {
			out.append("request.getSession().getId() ").append(session.getId() + "").append("<br>");
			out.append("session.getCreationTime() ").append(session.getCreationTime() + "").append("<br>");
			out.append("session.getLastAccessedTime() ").append(session.getLastAccessedTime() + "").append("<br>");
		}
		
		session = request.getSession();
		out.append("request.getSession().getId() ").append(session.getId() + "").append("<br>");
		
		
		session = request.getSession(true);
		
		out.append("Session ID after request.getSession(true).getId() ").append(session.getId() + "").append("<br>");
		out.append("session.getCreationTime() ").append(session.getCreationTime() + "").append("<br>");
		out.append("session.getLastAccessedTime() ").append(session.getLastAccessedTime() + "").append("<br>");
		
		session.invalidate();
		session = request.getSession(false);
		
		out.append("request.getSession() after session.invalidate() ").append(session + "").append("<br>");
		
		session = request.getSession();
		out.append("request.getSession().getId() ").append(session.getId() + "").append("<br>");
		
		out.append("</body>");
		out.append("</html>");
	}

}
