package com.filipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.filipe.model.Funcionario;
import com.filipe.model.InfoFuncionarioDTO;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	//Outra forma: 
	//@Query("SELECT DISTINCT f.txNome FROM Funcionario AS f WHERE f.salario BETWEEN :minimo AND :maximo")
	@Query("SELECT DISTINCT f.txNome FROM Funcionario AS f WHERE f.salario > :minimo AND f.salario < :maximo")
	public List<String> buscarFuncionariosSalarioEntre(@Param("minimo") Double minino, @Param("maximo") Double maximo);
	
	@Query("SELECT DISTINCT f.txNome FROM Funcionario AS f WHERE f.salario NOT BETWEEN :minimo AND :maximo")
	public List<String> buscarFuncionarioNotSalarioEntre(@Param("minimo") Double minino, @Param("maximo") Double maximo);
	
	@Query("SELECT DISTINCT f.txNome FROM Funcionario AS f WHERE f.cargo.txNome IN (:listaDeCargos)")
	public List<String> buscarFuncionariosNosCargos(@Param("listaDeCargos") List<String> listaDeCargos);
	
	@Query("SELECT DISTINCT f FROM Funcionario AS f WHERE f.salario >= 1700.0 ORDER BY f.salario")
	public List<Funcionario> buscarFuncionariosOrdenadosPorSalario();
	
	@Query("SELECT f.txNome, c.txNome FROM Funcionario f INNER JOIN f.cargo c")
	public List<Object[]> buscarInformacoesComJoin();
	
	@Query("SELECT f.txNome, c.txNome, d.txNome FROM Funcionario f INNER JOIN f.cargo c JOIN c.departamento d")
	public List<Object[]> buscarInformacoesComJoin2();
	
	@Query("SELECT NEW com.filipe.model.InfoFuncionarioDTO(f.txNome, c.txNome, d.txNome, f.salario, e.txLogradouro) "
			+ "FROM Funcionario f JOIN f.cargo c Join c.departamento d JOIN f.endereco e")
	public List<InfoFuncionarioDTO> buscarListaDeInformacoes();
}
