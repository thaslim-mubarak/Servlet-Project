package com.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DTO.Employee;
import com.Utility.Needfuls;

public class LoginDAO {

	public static void login(String email, String password, HttpServletRequest req, HttpServletResponse resp) {
		Query q = Needfuls.manager.createQuery(
				"select emp from Employee emp where emp.email = '" + email + "' and emp.password = '" + password + "'");

		PrintWriter pw = null;
		
		try {
			pw = resp.getWriter();
		} catch (IOException e) {

		}

		List<Employee> emps = q.getResultList();
		Employee emp = null;
		
		for(Employee e : emps) {
			emp = e;
		}
		
		if (emp == null) {
			pw.print("<html><body>");
			pw.print("<h2>Email id or Password is wrong</h3>");
			pw.print("</body></html>");
		}
		else {
			if (emp.getRole().equals("Manager")) {
				pw.print("<html><head><title>Manager Dashboard</title></head><body><h2>Hi " + emp.getName() + "!</h2>");
				pw.print("<a href = 'TaskUpdateManager.html'>Update the task of an employee</a><br><br>");
				pw.print("<a href = 'employees'>See all the employees</a><br><br>");
				pw.print("<a href = 'Main.html'>Logout</a><br><br>");
				pw.print("</body></html>");
			} else {
				HttpSession hs = req.getSession();
				hs.setAttribute("emp", emp);
				pw.print("<html><head><title>Manager Dashboard</title></head><body><h2>Hi " + emp.getName() + "!</h2>");
				pw.print("<a href = 'ViewTasks.jsp'>View Tasks</a><br><br>");
				pw.print("<a href = 'UpdateTaskEmployee.jsp'>Update Tasks</a><br><br>");
				pw.print("<a href = 'Main.html'>Logout</a><br><br>");
				pw.print("</body></html>");
			}
		}
	}
}