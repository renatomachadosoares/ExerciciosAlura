package br.com.reflection.modelo;

import java.math.BigDecimal;

public class Departamento {
	
	public String nome;
	public String filial;
	public BigDecimal faturamento;
	
	public Departamento() {		
		this.nome = "nome_default";
		this.filial = "filial_default";
		this.faturamento = new BigDecimal(10d);		
	}
		
	public Departamento(String nome, String filial, BigDecimal faturamento) {
		this.nome = nome;
		this.filial = filial;
		this.faturamento = faturamento;
	}
	
	public BigDecimal getFaturamento() {
		return faturamento;
	}
	public void setFaturamento(BigDecimal faturamento) {
		this.faturamento = faturamento;
	}

	@Override
	public String toString() {
		return "Departamento [nome=" + nome + ", filial=" + filial + ", faturamento=" + faturamento + "]";
	}
}
