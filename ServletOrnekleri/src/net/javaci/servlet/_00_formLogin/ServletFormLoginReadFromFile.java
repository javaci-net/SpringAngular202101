package net.javaci.servlet._00_formLogin;


import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormResponse
 */
@WebServlet("/ServletFormLoginReadFromFile")
public class ServletFormLoginReadFromFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Bir get isteginde bulundunuz");
		
		System.out.println("GET cagrisi yapildi.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		URL fileURL = Thread.currentThread().getContextClassLoader().getResource("formResponseTemplate.javaci");
		System.out.println(fileURL.getFile());
		
		String templateContent = new String(Files.readAllBytes(Paths.get(fileURL.getFile().substring(1))), StandardCharsets.UTF_8);
		
		if (request.getParameter("email") != null)
			templateContent = templateContent.replaceAll("@@email@@", request.getParameter("email"));
		
		if (request.getParameter("password") != null)
			templateContent = templateContent.replaceAll("@@password@@", request.getParameter("password"));
		
		response.getWriter().append(templateContent);
		
		System.out.println("POST cagrisi yapildi.");
	}
}
