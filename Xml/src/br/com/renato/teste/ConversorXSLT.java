package br.com.renato.teste;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConversorXSLT {

	public static void main(String[] args) throws Exception {

		Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource("src/conversorVendasXml.xsl"));
	
		StreamSource xmlSrc = new StreamSource("src/vendas.xml");
		
		Result outputTarget = new StreamResult("src/vendas.html");
		
		transformer.transform(xmlSrc, outputTarget);
		
		System.out.println("Transformação concluida!");

	}

}
