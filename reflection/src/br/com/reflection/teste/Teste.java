package br.com.reflection.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.reflection.modelo.Usuario;
import br.com.reflection.util.CheckAtributos;

public class Teste {

	public static void main(String[] args) {

//		Usuario usuario = new Usuario("Renato", "Machado", new BigDecimal(3d));
//		
//		Departamento departamento = new Departamento("Fabrica", "SP", new BigDecimal(1000d));
//		
//		System.out.println(CheckAtributos.getStringAttributes(usuario, "RenAtos"));
//		System.out.println(CheckAtributos.getStringAttributes(usuario, "Sousa"));
		
		
		Usuario usr = new Usuario("Renato", "Machado", new BigDecimal(2d));
		
		Map<String, Object> mapAttributes = CheckAtributos.getMapAttributes(usr);
		
		System.out.println("Obtendo mapa de atributos...");
		
		for(String key : mapAttributes.keySet()){
			
			System.out.println(key + ":" + mapAttributes.get(key));			
		}
		
		System.out.println("Executando testes...");
		
		
		try {
			CheckAtributos.invokeTestMethods(usr);
		} catch (Throwable e) {			
			e.printStackTrace();
		}
		
	}
	
}
