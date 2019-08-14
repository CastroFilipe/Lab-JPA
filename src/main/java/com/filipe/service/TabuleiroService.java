package com.filipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.model.Point;
import com.filipe.repository.TabuleiroRepository;

@Service
public class TabuleiroService {
	
	@Autowired
	private TabuleiroRepository repo;
	
	public void buscarPontos() {
		
		List<Point> pontos = repo.buscarPontos(2);
		
		System.out.println(pontos);
		
	}
	
	public void buscarPontosWhite() {
		List<Point> pontos = repo.buscarPontosWhite(2);
		
		System.out.println(pontos);
	}
}
