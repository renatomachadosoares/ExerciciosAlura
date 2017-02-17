package br.com.java8.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

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
		
		// Pegando o primeiro elemento da Stream:
		
		System.out.println("Primeiro elemento da stream: ");
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 50)
			.findFirst().ifPresent( t -> System.out.println(t.getNome()));
		
		List<Curso> collect = cursos.stream()
			.filter(c -> c.getAlunos() >= 50)
			.collect(Collectors.toList());
		
		System.out.println("Lista de cursos filtrados: " + collect);
		
		// Calculando a média de alunos em todos os cursos:
		
		System.out.println("Média de alunos por curso:");
		
		//Double media = cursos.stream().collect(Collectors.averagingInt(Curso::getAlunos));
		//System.out.println("Média de alunos: " + media);
		
		cursos.stream()
	    .mapToInt(c -> c.getAlunos())
	    .average().ifPresent(d -> System.out.println(d));
		
		
		
	}

}
