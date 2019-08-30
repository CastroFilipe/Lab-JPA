package com.filipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filipe.model.Cargo;
import com.filipe.repository.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Transactional(readOnly=true)
	public String buscarNomeCargo(Long id) {
		return cargoRepository.buscarNomeCargo(id);
	}
	
	@Transactional(readOnly=true)
	public List<Object[]> buscarNomeCargoEdepartamento(Long id){
		return cargoRepository.buscarNomeCargoEdepartamento(id);
	}
	
	@Transactional(readOnly=true)
	public List<String> buscarCargoLike(String nome){
		return cargoRepository.buscarCargoLike(nome);
	}
	
	@Transactional(readOnly=true)
	public Page<Cargo> findPage(Integer page, Integer linesPerPage){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		
		return cargoRepository.findPage(pageRequest);
	}
}
