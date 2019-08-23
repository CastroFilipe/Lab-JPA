package com.filipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.model.Funcionario;
import com.filipe.model.InfoFuncionarioDTO;
import com.filipe.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<String> buscarFuncionariosSalarioEntre(Double minimo, Double maximo){
		return funcionarioRepository.buscarFuncionariosSalarioEntre(minimo, maximo);
	}
	
	public List<String> buscarFuncionarioNotSalarioEntre(Double minimo, Double maximo){
		return funcionarioRepository.buscarFuncionarioNotSalarioEntre(minimo, maximo);
	}
	
	public List<String> buscarFuncionariosNosCargos(List<String> listaDeCargos){
		return funcionarioRepository.buscarFuncionariosNosCargos(listaDeCargos);
	}

	public List<Funcionario> buscarFuncionariosOrdenadosPorSalario(){
		return funcionarioRepository.buscarFuncionariosOrdenadosPorSalario();
	}
	
	public List<Object[]> buscarInformacoesComJoin(){
		return funcionarioRepository.buscarInformacoesComJoin();
	}
	
	public List<Object[]> buscarInformacoesComJoin2(){
		return funcionarioRepository.buscarInformacoesComJoin2();
	}
	
	public List<InfoFuncionarioDTO> buscarListaDeInformacoes(){
		return funcionarioRepository.buscarListaDeInformacoes();
	}
}
