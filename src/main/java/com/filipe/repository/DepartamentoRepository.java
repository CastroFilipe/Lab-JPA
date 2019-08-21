package com.filipe.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.filipe.model.Cargo;
import com.filipe.model.Departamento;

@Repository
public class DepartamentoRepository {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@PersistenceContext
	EntityManager em;

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

	public List<Departamento> buscarTodos() {
		TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d", Departamento.class);

		return query.getResultList();
	}

	// conta o número de registro em Departamento
	public Long contar() {
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(d) FROM Departamento d", Long.class);

		Long quantidade = query.getSingleResult();

		return quantidade;
	}

	public Departamento buscarPorNome(String nome) {

		Departamento departamento;

		try {
			TypedQuery<Departamento> query = em
					.createQuery("SELECT d FROM Departamento d WHERE d.txNome = :nome", Departamento.class)
					.setParameter("nome", nome);

			departamento = query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println(nome + "não encontrado");
			return null;
		}

		return departamento;
	}
	
	//retorna o nome de um Departamento
	public String buscarNomePorId(Long id) {
		TypedQuery<String> query = em.createQuery(
			      "SELECT d.txNome FROM Departamento AS d WHERE d.id = :id ", String.class)
				.setParameter("id", id);
		
			return query.getSingleResult();
	}
}
