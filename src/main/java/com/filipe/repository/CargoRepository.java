package com.filipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filipe.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
