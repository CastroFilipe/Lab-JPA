package com.filipe.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.filipe.model.Point;

@Repository
public class TabuleiroRepository {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@PersistenceContext
	EntityManager em;
	
	public List<Point> buscarPontos(Integer idTabuleiro){
		
		TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p WHERE p.tabuleiro.id = :idTabuleiro", Point.class)
				.setParameter("idTabuleiro", idTabuleiro);
		
		return query.getResultList();
	}
	
	public List<Point> buscarPontosWhite(Integer idTabuleiro){
		
		TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p WHERE p.tabuleiro.id = :idTabuleiro AND p.cor = 'WHITE'", Point.class)
				.setParameter("idTabuleiro", idTabuleiro);
		
		return query.getResultList();
	}
}
