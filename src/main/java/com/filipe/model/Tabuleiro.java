package com.filipe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tabuleiro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private TipoTabuleiro tipo;
	
	@OneToMany(mappedBy = "tabuleiro", cascade = CascadeType.ALL)
	private List<Point> points = new ArrayList<>();
	
	public Tabuleiro() {
	}

	public Tabuleiro(Integer id, String nome, TipoTabuleiro tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoTabuleiro getTipo() {
		return tipo;
	}

	public void setTipo(TipoTabuleiro tipo) {
		this.tipo = tipo;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tabuleiro [nome=");
		builder.append(nome);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", points=");
		builder.append(points);
		builder.append("]");
		return builder.toString();
	}
}
