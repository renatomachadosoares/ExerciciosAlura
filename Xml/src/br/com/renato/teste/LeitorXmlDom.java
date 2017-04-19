package br.com.renato.teste;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.renato.modelo.Produto;

public class LeitorXmlDom {

	public static void main(String[] args) throws Exception {
	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
//		factory.setValidating(true);
//		factory.setNamespaceAware(true);
//		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");		
		
		DocumentBuilder builder = factory.newDocumentBuilder();		
				
		Document doc = builder.parse(new File("src/vendas.xml"));		
				
		
		String expXpath = new String("/venda/produtos/produto[3]");
		XPath xpath = XPathFactory.newInstance().newXPath();
		
		XPathExpression expression = xpath.compile(expXpath);
						
		//NodeList produtos = doc.getElementsByTagName("produto");
		NodeList produtos = (NodeList)expression.evaluate(doc, XPathConstants.NODESET);
		
		for(int i = 0; i < produtos.getLength(); i++){
			
			Element produto = (Element) produtos.item(i);
		    String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
		    String preco = produto.getElementsByTagName("preco").item(0).getTextContent();
		    
		    Produto p = new Produto(nome, Double.parseDouble(preco));
		    		    
		    System.out.println("-----------");
		    System.out.println(p);	
		    System.out.println("-----------");
			
		}		
	}

}
