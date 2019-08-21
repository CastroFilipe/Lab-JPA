package com.filipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.model.Cargo;
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
	
	public List<Departamento> buscarTodos(){
		return departamentoRepository.buscarTodos();
	}
	
	public Long contar() {
		return departamentoRepository.contar();
	}
	
	public Departamento buscarPorNome(String nome) {
		return departamentoRepository.buscarPorNome(nome);
	}
	
	public String buscarNomePorId(Long id) {
		return departamentoRepository.buscarNomePorId(id);
	}

}
