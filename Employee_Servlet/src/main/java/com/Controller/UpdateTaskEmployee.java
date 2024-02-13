package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UpdateTaskEmployeeDAO;

@WebServlet("/update-task-employee")
public class UpdateTaskEmployee extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int e_id = Integer.parseInt(req.getParameter("eid"));
		int t_id = Integer.parseInt(req.getParameter("tid"));
		
		UpdateTaskEmployeeDAO.update(req, resp, e_id, t_id);
	}
}
