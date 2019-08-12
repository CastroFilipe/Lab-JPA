package com.filipe.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

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

	public void contar() {
		Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
		// getSingleResult deve ser usado apenas quando se espera um único objeto como
		// resposta
		System.out.println("Total points: " + q1.getSingleResult());
	}

	public void calcularMedia() {
		Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
		// getSingleResult deve ser usado apenas quando se espera um único objeto como
		// respost
		System.out.println("AVG: " + q2.getSingleResult());
	}
}
