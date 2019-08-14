package com.filipe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ID_ENDERECO\"")
	private Long id;
	
	@Column(name = "\"TX_LOGRADOURO\"")
	private String txLogradouro;
	
	@OneToOne
	@JoinColumn(name = "\"ID_FUNCIONARIO\"")
	private Funcionario funcionario;
	
	public Endereco() {
	}

	public Endereco(Long id, String txLogradouro, Funcionario funcionario) {
		super();
		this.id = id;
		this.txLogradouro = txLogradouro;
		this.funcionario = funcionario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxLogradouro() {
		return txLogradouro;
	}

	public void setTxLogradouro(String txLogradouro) {
		this.txLogradouro = txLogradouro;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Endereco [id=");
		builder.append(id);
		builder.append(", txLogradouro=");
		builder.append(txLogradouro);
		builder.append(", funcionario=");
		builder.append(funcionario);
		builder.append("]");
		return builder.toString();
	}
}