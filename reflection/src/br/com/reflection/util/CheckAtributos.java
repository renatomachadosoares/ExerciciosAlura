package br.com.reflection.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CheckAtributos {
	
	public static boolean getStringAttributes(Object o, String value){
		
		try {			
			
			Class<?> classe = o.getClass();
							
			Field[] attribs = classe.getFields();
			
			for (Field field : attribs) {
				
				System.out.println("Avaliando atributo " + field.getName());
								
				Object fieldValue = field.get(o);
				
				if(fieldValue.getClass() == String.class)
				{
					System.out.println("ok, comp funcionou!");
				}
				
				if(fieldValue instanceof String){
					
					String stringValue = (String)fieldValue;
														
					if(stringValue.compareToIgnoreCase(value) == 0){
						return true;
					}
				}			
			}
			
			return false;
			
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Map<String, Object> getMapAttributes(Object obj){
		
		Map<String, Object> mapa = new HashMap<>(); 
		
		Class<?> c = obj.getClass();
		
		for(Field f : c.getDeclaredFields()){			
			
			try {
				
				f.setAccessible(true);				
				mapa.put(f.getName(), f.get(obj));
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				
				throw new RuntimeException(e);				
			}			
		}
		
		return mapa;
	}
	
	public static void invokeTestMethods(Object obj) throws Throwable{
		
		Class<?> c = obj.getClass();
		
		for(Method m : c.getDeclaredMethods())
		{
			if(m.getName().startsWith("test") && m.getReturnType() == void.class && m.getParameterTypes().length == 0){
			
				try {
					m.setAccessible(true);
					m.invoke(obj);
				} catch (IllegalAccessException | IllegalArgumentException e) {
															
					throw new RuntimeException(e);					
				}				
				catch (InvocationTargetException e){
					
					throw e.getTargetException();
					
					//e.getTargetException().printStackTrace();					
				}
			}
		}
	}

}
