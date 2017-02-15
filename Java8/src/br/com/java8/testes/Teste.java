package br.com.java8.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
	
		List<String> nomes = new ArrayList<>();
		
		nomes.add("João");
		nomes.add("Maria");
		nomes.add("Jucileine");
		nomes.add("Ana");
		nomes.add("Manoel");
		nomes.add("Claudia");
		nomes.add("Ali");
				
		nomes.sort(Comparator.comparing(t -> t.length()));
						
		nomes.forEach(System.out::println);		
	}	
}
