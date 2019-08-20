package com.filipe.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.filipe.model.Departamento;

@Repository
public class DepartamentoRepository {

	@Autowired
	private EntityManagerFactory emf;
	
	public Departamento inserir(Departamento departamento) {

		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(departamento);
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}

		return departamento;
	}
	
	public Departamento buscar(Class<Departamento> entityClass, Long id) {
		EntityManager em = emf.createEntityManager();
		
		return em.find(entityClass, id);
	}
	
	public Departamento editar(Departamento departamento) {
		
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(departamento);
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}

		return departamento;
	}

}
