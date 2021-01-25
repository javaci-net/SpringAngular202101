package net.javaci.servlet._00_formLogin;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletFormLogin
 */
@WebServlet("/ServletFormLogin")
public class ServletFormLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Bir get isteginde bulundunuz");
		
		System.out.println("GET cagrisi yapildi.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.append("<!DOCTYPE html><html><head></head><body>    <label ><b>Email: </b></label>    <label><b>");
		out.append(request.getParameter("email"));
		out.append("</b></label><br>        <label ><b>Password: </b></label>    <label><b>");
		out.append(request.getParameter("password"));
		out.append("</b></label><br>    <br></body></html>");
			
		System.out.println("POST cagrisi yapildi.");
	}

}
