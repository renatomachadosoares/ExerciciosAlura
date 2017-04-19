package br.com.renato.teste;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.renato.modelo.Produto;

public class HandlerXmlSax extends DefaultHandler {
	
	private StringBuilder conteudoElemento;
	private Produto produto;
	private List<Produto> listaProdutos = new ArrayList<>();
	
	public List<Produto> getListaProdutos(){
		return listaProdutos;
	}
	
	@Override
	public void startDocument() throws SAXException {
		
		System.out.println("Iniciando a leitura do xml...");		
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	
		if("produto".equals(qName)){
		
			System.out.println("Instanciando um novo produto...");
			
			produto = new Produto();			
		}
		
		conteudoElemento = new StringBuilder("");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {		
		conteudoElemento.append(new String(ch, start, length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	
		if("produto".equals(qName)){
			System.out.println("Adicionando novo produto na lista...");
			listaProdutos.add(produto);
		}
		if("nome".equals(qName)){
			System.out.println("Setando nome do produto...");
			produto.setNome(conteudoElemento.toString());
		}
		if("preco".equals(qName)){
			System.out.println("Setando preço do produto...");
			produto.setPreco(Double.parseDouble(conteudoElemento.toString()));
		}
	}
}
