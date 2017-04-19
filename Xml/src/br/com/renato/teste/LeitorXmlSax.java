package br.com.renato.teste;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class LeitorXmlSax {

	public static void main(String[] args) throws Exception {

		XMLReader XMLReader = XMLReaderFactory.createXMLReader();
		
		HandlerXmlSax handlerXmlSax = new HandlerXmlSax();
		
		XMLReader.setContentHandler(handlerXmlSax);
		
		InputStream stream = new FileInputStream("src/vendas.xml");
						
		XMLReader.parse(new InputSource(stream));
		
		System.out.println("Lista de produtos: " + handlerXmlSax.getListaProdutos());
		
		
	}

}
