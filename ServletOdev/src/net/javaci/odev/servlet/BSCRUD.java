package net.javaci.odev.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaci.odev.model.Employee;

@WebServlet("/BSCRUD")
public class BSCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Thread safe olmayan bir listedir ancak bu odev icin thread safe ligi onemsemiyoruz
	private List<Employee> employees = new ArrayList<Employee>();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET METHOD");
		
		loadFromTemplate(response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST METHOD");
		
		String operationType = request.getParameter("operation_type");
		
		if (operationType == null || 
				(!operationType.equals("delete") && 
				 !operationType.equals("add") && 
				 !operationType.equals("edit"))) {
			response.getWriter().append("Invalid operation type");
			return;
		} 
		switch (operationType) {
		case "delete":
			String idStr = request.getParameter("delete_customer_id");
			// TODO listeden ilgili id ye sahip emplopyee bul ve cikart
			break;
		case "add":
			// TODO parametrelerden name ve email li al
			// TODO bunlarla yeni employee nesnesi olustur
			// TODO yeni nesneyi employees listesine ekle
			break;
		case "edit":
			// TODO parametrelerden employee_id, name ve email li al
			// TODO listenin icinden bu id li employee yi bul
			// TODO buldugun employee nin name ve email alanlarini guncelle
			break;
		}
		
		loadFromTemplate(response.getWriter());
		
	}
	
	private void loadFromTemplate(PrintWriter out) {
		// TODO Burada template e erisili listedeki elemanlari template in icine yerlestirecewksiniz
	}

}
