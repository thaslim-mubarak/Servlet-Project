package com.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DTO.Employee;
import com.Utility.Needfuls;

public class EmployeeFetchManagerDAO {
	
	public static void fetch(HttpServletRequest req, HttpServletResponse resp) {
		
		Query q = Needfuls.manager.createQuery("select emp from Employee emp");
		List<Employee> employees = q.getResultList();
		
		PrintWriter pw = null;
		try {
			pw = resp.getWriter();
		} catch (IOException e) {
			
		}
				
		if(employees != null && !employees.isEmpty()) {
			for(Employee e : employees) {
				if(e.getRole().equals("Employee")) {
					pw.print("<html><body>");
					pw.print("<h3>Employee Id: "+e.getId()+"</h5>");
					pw.print("<h5>Employee name: "+e.getName()+"</h5>");
					pw.print("<h5>Employee email: "+e.getEmail()+"</h5>");
					pw.print("<h5>Employee role: "+e.getRole()+"</h5>");
					pw.print("<h5>Employee designation: "+e.getDesignation()+"</h5>");
					pw.print("<h5></h5>");
					pw.print("</body></html>");
				}
			}
		}
		else {
			pw.print("<html><body>");
			pw.print("<h3>No employees found</h3>");
			pw.print("</body></html>");
		}
	}

}
