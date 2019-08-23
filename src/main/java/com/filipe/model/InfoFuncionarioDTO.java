package com.filipe.model;

import java.io.Serializable;

public class InfoFuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nomeFuncionario;
	
	private String cargoFuncionario;
	
	private String departamentoFuncionario;
	
	private Double salario;
	
	private String logradouro;
	
	public InfoFuncionarioDTO() {
	}

	public InfoFuncionarioDTO(String nomeFuncionario, String cargoFuncionario, String departamentoFuncionario,
			Double salario, String logradouro) {
		super();
		this.nomeFuncionario = nomeFuncionario;
		this.cargoFuncionario = cargoFuncionario;
		this.departamentoFuncionario = departamentoFuncionario;
		this.salario = salario;
		this.logradouro = logradouro;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getCargoFuncionario() {
		return cargoFuncionario;
	}

	public void setCargoFuncionario(String cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}

	public String getDepartamentoFuncionario() {
		return departamentoFuncionario;
	}

	public void setDepartamentoFuncionario(String departamentoFuncionario) {
		this.departamentoFuncionario = departamentoFuncionario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nFicha do Funcionario: [nomeFuncionario=");
		builder.append(nomeFuncionario);
		builder.append(", cargoFuncionario=");
		builder.append(cargoFuncionario);
		builder.append(", departamentoFuncionario=");
		builder.append(departamentoFuncionario);
		builder.append(", salario=");
		builder.append(salario);
		builder.append(", logradouro=");
		builder.append(logradouro);
		builder.append("]");
		return builder.toString();
	}
}
