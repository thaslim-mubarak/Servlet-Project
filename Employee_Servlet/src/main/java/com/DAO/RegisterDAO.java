package com.DAO;

import com.DTO.Employee;
import com.Utility.Needfuls;

public class RegisterDAO {

	public static void register(String name, String email, String password, String role, String designation,
			double salary) {
		Employee emp = new Employee(name, email, password, role, designation, salary);

		Needfuls.transaction.begin();

		Needfuls.manager.persist(emp);

		Needfuls.transaction.commit();
	}

}
