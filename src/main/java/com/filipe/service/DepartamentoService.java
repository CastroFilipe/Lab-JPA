package com.filipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.model.Departamento;
import com.filipe.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public Departamento inserir(Departamento departamento) {
		return departamentoRepository.inserir(departamento);
	}
	
	public Departamento buscar(Long id) {
		return departamentoRepository.buscar(Departamento.class, id);
	}
	
	public Departamento editar(Departamento departamento) {
		if(departamento.getId() == null)
			throw new IllegalArgumentException("Id nao pode ser nulo");
		
		return departamentoRepository.editar(departamento);
	}
}
