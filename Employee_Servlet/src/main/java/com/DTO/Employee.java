package com.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "id")
	@SequenceGenerator(name = "id", initialValue = 101, allocationSize = 1, sequenceName = "employee_id")
	int id;
	String name;
	String email;
	String password;
	String role;
	String designation;
	double salary;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Task> tasks;

	public Employee() {
		super();
	}

	public Employee(String name, String email, String password, String role, String designation, double salary) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.designation = designation;
		this.salary = salary;
	}
	
	public String getDesignation() {
		return designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", designation=" + designation + ", tasks="
				+ tasks + "]";
	}

}
