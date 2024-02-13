<%@page import="java.util.Collections"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.DTO.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.DTO.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task List</title>
</head>
<body>

	<%

	Employee emp = (Employee) session.getAttribute("emp");
	List<Task> tasks = emp.getTasks();
	
	
	
	Collections.sort(tasks);

	PrintWriter pw = response.getWriter();

	if (!tasks.isEmpty()) {
		for (Object obj : tasks) {
			
			Task t = (Task)obj;
			
			pw.print("<html><body>");
			pw.print("<h3>Task Id: " + t.getId() + "</h3>");
			pw.print("<h4>Task description: " + t.getDescription() + "</h4>");
			pw.print("<h3>Status: " + t.getStatus() + "</h3>");
			pw.print("<h3>Completed On: " + t.getCompleted_on() + "</h3>");
			pw.print("</body></html>");

		}
	} else {
		pw.print("<html><body>");
		pw.print("<h2>No tasks assigned for you</h2>");
		pw.print("</body></html>");
	}
	%>

</body>
</html>