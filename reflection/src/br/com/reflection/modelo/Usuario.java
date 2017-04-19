package br.com.reflection.modelo;

import java.math.BigDecimal;

public class Usuario {

	public String nome;
	public String sobrenome;
	private BigDecimal salario;
	
	public Usuario(String nome, String sobrenome, BigDecimal salario) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.salario = salario;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}	
	
	public void testNome(){
		System.out.println("Testando nome: " + nome);
	}
	
	private void testSalario(){
		System.out.println("Testando salario: " + salario);
	}
	
	public void testSobrenome(){		
		throw new IllegalArgumentException();		
	}
}
