package com.filipe.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.model.Point;
import com.filipe.model.Tabuleiro;
import com.filipe.repository.PointRepository;

@Service
public class PointService {

	@Autowired
	private PointRepository pointRepo;

	public void obter() {

	}

	@Transactional
	public void inserirDez() {
		pointRepo.inserirPontos();
		
	}
	
	public void consultas() {
		pointRepo.contar();
		pointRepo.calcularMedia();
		System.out.println(pointRepo.buscarTodos());
		
		Point p = pointRepo.buscarPorId(5);
		
		System.out.println(p);
		
		Tabuleiro tab = p.getTabuleiro();
		
		System.out.print(tab);
	}
}
