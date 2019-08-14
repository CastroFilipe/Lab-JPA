package com.filipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filipe.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
