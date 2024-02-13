package com.Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Needfuls {
	
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee_servlet");
	public static EntityManager manager = factory.createEntityManager();
	public static EntityTransaction transaction = manager.getTransaction();

}
