package com.filipe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString(of = "cargos")
@EqualsAndHashCode(of = "id")
public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ID_DEPARTAMENTO\"")
	private Long id;
	
	@Column(name = "\"TX_NOME\"")
	@Basic
	private String txNome;
	
	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos = new ArrayList<>();

	
}
