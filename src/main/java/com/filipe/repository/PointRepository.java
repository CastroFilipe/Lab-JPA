package com.filipe.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

			for (int i = 0; i < 5; i++) {
				entManager.persist(new Point(null, i, i, "BLACK", 1.2));
				entManager.persist(new Point(null, -i, -i, "GREEN", 1.9));
			}

			entManager.getTransaction().commit();
		} finally {
			entManager.close();
		}

	}

	public void contar() {
		Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
		// getSingleResult deve ser usado apenas quando se espera um único objeto como resposta
		System.out.println("Total points: " + q1.getSingleResult());
	}

	public void calcularMedia() {
		Query q2 = em.createQuery("SELECT AVG(p.cordenada_x) FROM Point p");
		// getSingleResult deve ser usado apenas quando se espera um único objeto como resposta
		System.out.println("AVG: " + q2.getSingleResult());
	}
	
	public List<Point> buscarTodos() {
		TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
		
		List<Point> results = query.getResultList();
		
		return results;
	}
	
	public Point buscarPorId(Integer id) {
		TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p WHERE p.id = :point_id", Point.class)
				.setParameter("point_id", id);
		
		return query.getSingleResult();
	}
}
