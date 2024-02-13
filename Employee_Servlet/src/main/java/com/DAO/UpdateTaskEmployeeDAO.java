package com.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DTO.Employee;
import com.DTO.Task;
import com.Utility.Needfuls;

public class UpdateTaskEmployeeDAO {

	public static void update(HttpServletRequest req, HttpServletResponse resp, int e_id, int t_id) {
		Employee emp = Needfuls.manager.find(Employee.class, e_id);

		List<Task> tasks = null;
		Task task = null;

		PrintWriter pw = null;
		try {
			pw = resp.getWriter();
		} catch (IOException e) {

		}

		if (emp != null) {
			tasks = emp.getTasks();

			for (Task t : tasks) {
				if (t.getId() == t_id) {
					task = t;
				}
			}
		}
		else {
			pw.print("<html><body>");
			pw.print("<h2>Invalid employee id</h2>");
			pw.print("</body></html>");
		}
		
		try {
			if (task.getStatus().equals("Open")) {

				task.setStatus("Closed");
				task.setCompleted_on(LocalDateTime.now());

				Needfuls.transaction.begin();
				Needfuls.manager.merge(task);
				Needfuls.transaction.commit();

				pw.print("<html><body>");
				pw.print("<h2>Task status updated</h2>");
				pw.print("</body></html>");
			} else {
				pw.print("<html><body>");
				pw.print("<h2>Check the employee id and task id once</h2>");
				pw.print("</body></html>");
			}
		}
		catch (NullPointerException e) {
			pw.print("<html><body>");
			pw.print("<h2>No tasks assigned for the employee</h2>");
			pw.print("</body></html>");
		}
	}

}
