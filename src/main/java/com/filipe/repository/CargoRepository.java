package com.filipe.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.filipe.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	//Cláusula As opcional.
	@Query("SELECT DISTINCT c.txNome FROM Cargo AS c WHERE c.id = :id")
	public String buscarNomeCargo(@Param("id") Long id);
	
	@Query("SELECT DISTINCT c.txNome, c.departamento.txNome FROM Cargo AS c WHERE c.id = :id")
	public List<Object[]> buscarNomeCargoEdepartamento(@Param("id") Long id);
	
	@Query("SELECT c.txNome FROM Cargo AS c WHERE c.txNome LIKE %:nome%")
	public List<String> buscarCargoLike(@Param("nome") String nome);
	
	@Query("SELECT DISTINCT c FROM Cargo c")
	Page<Cargo> findPage(PageRequest pageRequest);
}
