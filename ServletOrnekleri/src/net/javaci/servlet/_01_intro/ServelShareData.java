package net.javaci.servlet._01_intro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServelShareData
 */
@WebServlet(urlPatterns = {"/ServelShareData", "/veli"}, loadOnStartup = 1)
public class ServelShareData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int counter = 0;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int counterValue = counter;
		counterValue++;
		response.getWriter().append("counter = " + counterValue + " ").append(request.getContextPath());
		
		counter = counterValue;
		System.out.println("ServelShareData doGet");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("ServelShareData service (HttpServletRequest)");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		super.service(req, res);
		System.out.println("ServelShareData service (ServletRequest)");
	}

	@Override
	public void destroy() {
		System.out.println("ServelShareData destroy");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("ServelShareData init");
		super.init();
	}
}
