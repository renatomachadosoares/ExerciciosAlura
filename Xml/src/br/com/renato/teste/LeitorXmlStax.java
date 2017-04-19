package br.com.renato.teste;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import br.com.renato.modelo.Produto;

public class LeitorXmlStax {

	public static void main(String[] args) throws Exception {

		XMLInputFactory factory = XMLInputFactory.newFactory();
		
		XMLEventReader listaEventos = factory.createXMLEventReader(new FileInputStream("src/vendas.xml"));
		
		List<Produto> listaProdutos = new ArrayList<>();	
		
		while(listaEventos.hasNext()){
			
			XMLEvent event = listaEventos.nextEvent();
			
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("produto")){
				
				Produto produto = instanciaNovoProduto(listaEventos);
				
				System.out.println("Adicionando novo produto...");
				
				listaProdutos.add(produto);
			}			
		}
		
		System.out.println("Lista de produtos: " + listaProdutos);
		
	}

	private static Produto instanciaNovoProduto(XMLEventReader listaEventos) throws Exception {

		Produto produto = new Produto();
		
		while(listaEventos.hasNext()){
			
			XMLEvent evento = listaEventos.nextEvent();
			
			if(evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")){
				break;
			}
			
			if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("nome")){
				evento = listaEventos.nextEvent();
				produto.setNome(evento.asCharacters().getData());
			}
			
			if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")){
				evento = listaEventos.nextEvent();
				produto.setPreco(Double.parseDouble(evento.asCharacters().getData()));
			}			
		}
		
		return produto;		
	}

}
