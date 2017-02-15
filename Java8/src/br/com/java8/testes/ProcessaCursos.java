package br.com.java8.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ProcessaCursos {
	
	public static void main(String[] args) {
						
		List<Curso> cursos = new ArrayList<>();
		
		cursos.add(new Curso("Matemática", 100));
		cursos.add(new Curso("Portugues", 75));
		cursos.add(new Curso("Fisica", 49));
		cursos.add(new Curso("Inglês", 87));
		cursos.add(new Curso("História", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));

		cursos.stream()
			.filter(c -> c.getAlunos() >= 50)
			.map(Curso::getNome)
			.forEach(System.out::println);		
		
		System.out.println("------------");
		
		cursos.forEach((Curso c) -> System.out.println(c.getNome()));
		
		
	}

}
