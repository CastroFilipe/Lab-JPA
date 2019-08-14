package com.filipe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ID_DEPARTAMENTO\"")
	private Long id;
	
	@Column(name = "\"TX_NOME\"")
	private String txNome;
	
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
		Departamento other = (Departamento) obj;
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
		builder.append("Departamento [id=");
		builder.append(id);
		builder.append(", txNome=");
		builder.append(txNome);
		builder.append("]");
		return builder.toString();
	}
}
