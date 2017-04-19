package br.com.reflection.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MapaDeClasses {
	
	public static void main(String[] args) {
		
		MapaDeClasses mapaDeClasses = new MapaDeClasses();
		
		Class<?> classLoad = mapaDeClasses.getClass("modelo_departamento");
						
		System.out.println("Obtendo instância da classe através de construtor sem parâmetros...");
		
		System.out.println(mapaDeClasses.getObject("modelo_departamento").toString());
		
		System.out.println("Obtendo instância da classe através de construtor com parâmetros...");
		
		Object object = mapaDeClasses.getObject("modelo_departamento", "Comercial", "São Paulo", new BigDecimal(25000d));
		
		System.out.println(object.toString());
		
		mapaDeClasses.printConstructors("modelo_departamento");
		
		
		
	}

	private Map<String, Class<?>> mapClasses = new HashMap<String, Class<?>>();
	
	public MapaDeClasses() {
		loadMap();	
	}
	
	private void loadMap(){
		
		Properties propClass = new Properties();
						
		try {
			
			propClass.load(new FileInputStream("arq_map_classes.prop"));
									
			Set<Object> keySet = propClass.keySet();
									
			for (Object classKey : keySet) {
				
				String cn = propClass.getProperty((String)classKey);
				
				mapClasses.put((String)classKey, Class.forName(cn));
			}
			
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Class<?> getClass(String className){		
		return mapClasses.get(className);				
	}
	
	public Object getObject(String className){
		
		Class<?> classe = this.getClass(className);
				
		try {
			return classe.newInstance();						
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Object getObject(String className, Object... parmsConst){

		try {

			Class<?> classe = this.getClass(className);

			Class<?>[] pC = new Class<?>[parmsConst.length];

			for(int i = 0; i < parmsConst.length; i++){
				pC[i] = parmsConst[i].getClass();
			}

			return classe.getConstructor(pC).newInstance(parmsConst);			
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			
			throw new RuntimeException(e);			
		}		
	}	
	
	public void printConstructors(String className){
		
		Class<?> classe = this.getClass(className);
		
		Constructor<?>[] constructs = classe.getConstructors();
		
		System.out.println("Imprimindo construtores e seus parâmetros para a classe '" + classe.getSimpleName() + "':");
		
		int ind = 1;
		
		for (Constructor<?> constructor : constructs) {
			
			System.out.println("Construtor #" + ind);
			
			System.out.println("Nome: " + constructor.getName());
									
			Parameter[] parameters = constructor.getParameters();
			
			if(parameters.length > 0){
				
				System.out.println("Parâmetros: ");

				for (Parameter parameter : parameters) {
					System.out.println(parameter.getName() + "[" + parameter.getType().getName() + "]");				
				}				
			}
			
			ind++;
		}		
	}	
}
