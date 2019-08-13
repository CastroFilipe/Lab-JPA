package com.filipe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Point {
    // Persistent Fields:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    private Integer cordenada_x;
    
    private Integer cordenada_y;
    
    private String cor;
    
    private Double diametro;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Tabuleiro tabuleiro;
    
    public Point() { 	
    }

	public Point(Integer id, Integer cordenada_x, Integer cordenada_y, String cor, Double diametro,
			Tabuleiro tabuleiro) {
		super();
		this.id = id;
		this.cordenada_x = cordenada_x;
		this.cordenada_y = cordenada_y;
		this.cor = cor;
		this.diametro = diametro;
		this.tabuleiro = tabuleiro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCordenada_x() {
		return cordenada_x;
	}

	public void setCordenada_x(Integer cordenada_x) {
		this.cordenada_x = cordenada_x;
	}

	public Integer getCordenada_y() {
		return cordenada_y;
	}

	public void setCordenada_y(Integer cordenada_y) {
		this.cordenada_y = cordenada_y;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getDiametro() {
		return diametro;
	}

	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	// String Representation:
    @Override
    public String toString() {
        return String.format("%s (%d, %d)",this.cor, this.cordenada_x, this.cordenada_y);
    }
}
