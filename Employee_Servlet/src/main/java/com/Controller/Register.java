package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.RegisterDAO;

@WebServlet("/register")
public class Register extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String designation = req.getParameter("designation");
		double salary = Double.parseDouble(req.getParameter("salary"));
		
		RegisterDAO.register(name, email, password, role, designation, salary);
		
	}
	
}
