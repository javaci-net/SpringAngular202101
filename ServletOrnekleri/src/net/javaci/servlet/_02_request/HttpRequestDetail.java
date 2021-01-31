package net.javaci.servlet._02_request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpRequestDetail
 */
@WebServlet("/HttpRequestDetail")
public class HttpRequestDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		

		// response.setStatus(404);
		// response.setContentType("application/json");

		out.append("<html>");
		out.append("<body>");

		out.append("getContextPath ").append(request.getContextPath()).append("<br>");
		out.append("getLocalAddr ").append(request.getLocalAddr()).append("<br>");
		out.append("getLocalName ").append(request.getLocalName()).append("<br>");
		out.append("getLocalPort ").append(request.getLocalPort() + "").append("<br>");
		out.append("getRemoteAddr ").append(request.getRemoteAddr()).append("<br>");
		out.append("getRemoteHost ").append(request.getRemoteHost()).append("<br>");
		out.append("getRemotePort ").append(request.getRemotePort() + "").append("<br>");
		out.append("getRemoteUser ").append(request.getRemoteUser()).append("<br>");
		out.append("getContentType ").append(request.getContentType()).append("<br>");
		out.append("getPathInfo ").append(request.getPathInfo()).append("<br>");
		out.append("getMethod ").append(request.getMethod()).append("<br>");
		out.append("getPathTranslated ").append(request.getPathTranslated()).append("<br>");
		out.append("getProtocol ").append(request.getProtocol()).append("<br>");
		out.append("getQueryString ").append(request.getQueryString()).append("<br>");
		out.append("getRequestedSessionId ").append(request.getRequestedSessionId()).append("<br>");
		out.append("getRequestURI ").append(request.getRequestURI()).append("<br>");
		out.append("getRequestURL ").append(request.getRequestURL()).append("<br>");
		out.append("getScheme ").append(request.getScheme()).append("<br>");
		out.append("getServerName ").append(request.getServerName()).append("<br>");
		out.append("getServletPath ").append(request.getServletPath()).append("<br>");
		out.append("getServerPort ").append(request.getServerPort() + "").append("<br>");
		out.append("getContentLength ").append(request.getContentLength() + "").append("<br>");
		out.append("getCookies ").append(request.getCookies() + "").append("<br>");

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String element = headerNames.nextElement();
			out.append("\tgetHeaderNames  - ").append(element).append(" = ").append(request.getHeader(element)).append("<br>");
		}

		out.append("getHttpServletMapping getMatchValue = ").append(request.getHttpServletMapping().getMatchValue()).append("<br>");
		out.append("getHttpServletMapping getPattern = ").append(request.getHttpServletMapping().getPattern()).append("<br>");
		out.append("getHttpServletMapping getServletName = ").append(request.getHttpServletMapping().getServletName()).append("<br>");
		out.append("getHttpServletMapping getMappingMatch = ").append(request.getHttpServletMapping().getMappingMatch().name()).append("<br>");
		
		
		out.append("getUserPrincipal ").append(request.getUserPrincipal() + "").append("<br>");

		out.append("</body>");
		out.append("</html>");


	}
}
