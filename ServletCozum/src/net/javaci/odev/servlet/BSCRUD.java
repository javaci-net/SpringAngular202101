package net.javaci.odev.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

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
			delete(request);
			break;
		case "add":
			add(request);
			break;
		case "edit":
			edit(request);
			break;
		}
		
		loadFromTemplate(response.getWriter());
		
	}

	private void edit(HttpServletRequest request) {
		// TODO parametrelerden employee_id, name ve email li al
		String idStr = request.getParameter("employee_id");
		int id = Integer.parseInt(idStr);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		// TODO listenin icinden bu id li employee yi bul
		Employee employeeToEdit = null;
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				employeeToEdit = employee;
				break;
			}
		}
		
		// TODO buldugun employee nin name ve email alanlarini guncelle
		employeeToEdit.setName(name);
		employeeToEdit.setEmail(email);
	}

	private void delete(HttpServletRequest request) {
		String idStr = request.getParameter("delete_customer_id");
		int id = Integer.parseInt(idStr);
		
		// TODO listeden ilgili id ye sahip emplopyee bul ve cikart
		Employee employeeToRemove = null;
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				employeeToRemove = employee;
				break;
			}
		}
		if (employeeToRemove != null) {
			employees.remove(employeeToRemove);
		}
	}

	private void add(HttpServletRequest request) {
		// TODO parametrelerden name ve email li al
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int id;
		OptionalInt optinal = employees.stream().mapToInt(e -> e.getId()).max();
		if (optinal.isEmpty()) {
			id = 1;
		} else {
			id = optinal.getAsInt() + 1;
		}
		// TODO bunlarla yeni employee nesnesi olustur
		Employee e = new Employee(id, name, email);
		// TODO yeni nesneyi employees listesine ekle
		employees.add(e);
	}
	
	private void loadFromTemplate(PrintWriter out) throws IOException {
		// TODO Burada template e erisili listedeki elemanlari template in icine yerlestirecewksiniz
		
		
		/*
			<tr>
				<td>1</td>
				<td>Thomas Hardy</td>
				<td>thomashardy@mail.com</td>
				<td>
					<a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit" onclick="editItem(1, 'Thomas Hard', 'thomashardy@mail.com')" >&#xE254;</i></a>
					<a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete" onclick="deleteItem(1)">&#xE872;</i></a>
				</td>
			</tr>

		 */
		StringBuilder sb = new StringBuilder();
		for (Employee employee : employees) {
			sb.append("<tr>\n");
			
			sb.append("<td>");
			sb.append(employee.getId());
			sb.append("</td>\n");
			
			sb.append("<td>");
			sb.append(employee.getName());
			sb.append("</td>\n");
			
			sb.append("<td>");
			sb.append(employee.getEmail());
			sb.append("</td>\n");
			
			sb.append("<td>\n");
			sb.append("<a href=\"#editEmployeeModal\" class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\" onclick=\"editItem(");
			sb.append(employee.getId());
			sb.append(", '");
			sb.append(employee.getName());
			sb.append("', '");
			sb.append(employee.getEmail());
			sb.append("')\" >&#xE254;</i></a>\n");
			
			
			sb.append("<a href=\"#deleteEmployeeModal\" class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\" onclick=\"deleteItem(");
			sb.append(employee.getId());
			sb.append(")\">&#xE872;</i></a>\n");
			sb.append("</td>\n");
			sb.append("</tr>\n");
		}
		
		
		URL fileURL = Thread.currentThread().getContextClassLoader().getResource("employee_crud.javaci");
		
		String templateContent = new String(Files.readAllBytes(Paths.get(fileURL.getFile().substring(1))), StandardCharsets.UTF_8);
		
		templateContent = templateContent.replaceAll("@@table_body@@", sb.toString());
		
		out.write(templateContent);
		
	}

}
