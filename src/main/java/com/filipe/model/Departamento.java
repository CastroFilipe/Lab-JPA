package com.filipe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SEQ_DEPARTAMENTO", sequenceName="SQ_DEPARTAMENTO",initialValue = 1, allocationSize = 1)
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DEPARTAMENTO")
	//@Column(name = "\"ID_DEPARTAMENTO\"")
	private Long id;

	//@Column(name = "\"TX_NOME\"")
	@Basic
	private String txNome;

//	@Column(name = "\"TX_TESTE\"")
//	@Basic
//	private String txTeste;

	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos = new ArrayList<>();
	
	public Departamento() {
	}

	public Departamento(Long id, String txNome) {
		super();
		this.id = id;
		this.txNome = txNome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxNome() {
		return txNome;
	}

	public void setTxNome(String txNome) {
		this.txNome = txNome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Departamento [id=");
		builder.append(id);
		builder.append(", txNome=");
		builder.append(txNome);
		builder.append("]");
		return builder.toString();
	}
}
