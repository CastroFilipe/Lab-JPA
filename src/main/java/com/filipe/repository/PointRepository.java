package com.filipe.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.filipe.model.Point;

@Repository
public class PointRepository {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@PersistenceContext
	EntityManager em;
	
	public void inserirDez() {
	EntityManager entManager = emf.createEntityManager();
		
		try {
			entManager.getTransaction().begin();

			for (int i = 0; i < 10; i++) {
				entManager.persist(new Point(i, i, i));
			}
			
			entManager.getTransaction().commit();
		} finally {
			entManager.close();
		} 
	}
}
