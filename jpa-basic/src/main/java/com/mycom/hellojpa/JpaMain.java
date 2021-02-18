package com.mycom.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName: "hello");
		
		EntityManager entityManager = emf.createEntityManager();
		entityManager.close();
		
		emf.close();
	}

}
