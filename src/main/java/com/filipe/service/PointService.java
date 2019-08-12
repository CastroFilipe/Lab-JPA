package com.filipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.repository.PointRepository;

@Service
public class PointService {

	@Autowired
	private PointRepository pointRepo;

	public void obter() {

	}

	//@Transactional
	public void inserirDez() {
		pointRepo.inserirDez();
		pointRepo.calcularMedia();
		pointRepo.contar();
	}
}
