package com.filipe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ID_FUNCIONARIO\"")
	private Long id;

	@Column(name = "\"TX_NOME\"")
	private String txNome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "EN_TIPO_FUNCIONARIO")
	private TipoFuncionario tipoFuncionario;
	
	@OneToOne(mappedBy = "funcionario")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "\"ID_CARGO\"")
	private Cargo cargo;
	
	public Funcionario() {
	}

	public Funcionario(Long id, String txNome, TipoFuncionario tipoFuncionario, Endereco endereco, Cargo cargo) {
		super();
		this.id = id;
		this.txNome = txNome;
		this.tipoFuncionario = tipoFuncionario;
		this.endereco = endereco;
		this.cargo = cargo;
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

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [id=");
		builder.append(id);
		builder.append(", txNome=");
		builder.append(txNome);
		builder.append(", tipoFuncionario=");
		builder.append(tipoFuncionario);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", cargo=");
		builder.append(cargo);
		builder.append("]");
		return builder.toString();
	}
}
