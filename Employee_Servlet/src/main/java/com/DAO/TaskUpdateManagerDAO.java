package com.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DTO.Employee;
import com.DTO.Task;
import com.Utility.Needfuls;

public class TaskUpdateManagerDAO {

	public static void update(HttpServletRequest req, HttpServletResponse resp, int id, String description) {
		
		PrintWriter pw = null;
		try {
			pw = resp.getWriter();
		} catch (IOException e) {
			
		}

		Employee emp = Needfuls.manager.find(Employee.class, id);

		if (emp != null) {
			Task t = new Task(description, "Open");

			List<Task> tasks = emp.getTasks();

			if (tasks == null) {
				tasks = new ArrayList<Task>();
				tasks.add(t);
				emp.setTasks(tasks);
			}
			else {
				tasks.add(t);
				emp.setTasks(tasks);
			}

			Needfuls.transaction.begin();
			Needfuls.manager.merge(emp);
			Needfuls.transaction.commit();

			pw.print("<html><body>");
			pw.print("Task updated");
			pw.print("</body></html>");
		} else {
			pw.print("<html><body>");
			pw.print("<h3>Entered employee Id doesn't exists</h3>");
			pw.print("</body></html>");
		}
	}

}
