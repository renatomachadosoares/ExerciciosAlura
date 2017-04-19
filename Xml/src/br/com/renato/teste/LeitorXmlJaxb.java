package br.com.renato.teste;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

import br.com.renato.modelo.Produto;
import br.com.renato.modelo.Venda;

public class LeitorXmlJaxb {

	public static void main(String[] args) throws Exception {

		JAXBContext context = JAXBContext.newInstance(Venda.class);
		
		deXmlParaObjeto(context);
		
		deObjetoParaXml(context);
		
		
	}

	private static void deObjetoParaXml(JAXBContext context) throws Exception {
		
		Marshaller marshaller = context.createMarshaller();
		
		List<Produto> produtos = new ArrayList<>();
		
		produtos.add(new Produto("Super Mario Bros", 150.0));
		produtos.add(new Produto("Super Mario 2", 180.0));
		produtos.add(new Produto("Super Mario 3", 200.0));
		
		Venda venda = new Venda();
		
		venda.setFormaDePagamento("dinheiro");
		venda.setMoeda("libra");
		venda.setProdutos(produtos);
		
		StreamResult writer = new StreamResult(new File("src/outputJaxb.xml"));
				
		marshaller.marshal(venda, writer);
		
		System.out.println("\n\nProcesso de marshaller finalizado!");
		
		
	}

	private static void deXmlParaObjeto(JAXBContext context) throws Exception {
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		InputSource src = new InputSource(new FileInputStream("src/vendas.xml")); 
					
		Venda venda = (Venda)unmarshaller.unmarshal(src);
		
		System.out.println(venda);		
		
		System.out.println("Processo de unmarshaller finalizado!");
	}

}
