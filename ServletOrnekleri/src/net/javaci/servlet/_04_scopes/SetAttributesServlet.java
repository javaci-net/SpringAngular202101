package net.javaci.servlet._04_scopes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetAttributesServlet
 */
@WebServlet("/SetAttributesServlet")
public class SetAttributesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // set application scoped attribute
		getServletContext().setAttribute("name", "application scoped attribute");

        // set session scoped attribute
        HttpSession session = request.getSession();
        session.setAttribute("name", "session scoped attribute");

        // set request scoped attribute
        request.setAttribute("name", "request scoped attribute");

        // send redirect to other servlet
        request.getRequestDispatcher("GetAttributesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
