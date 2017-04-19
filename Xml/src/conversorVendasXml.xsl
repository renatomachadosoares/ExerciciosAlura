<?xml version="1.0" encoding="ISO-8859-9"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:template match="venda">
	
		<h1>Vendas</h1>
	
		<p>Forma de pagamento: <xsl:value-of select="formaDePagamento"/></p>
	
		<xsl:apply-templates select="produtos"/>
		
	</xsl:template>
	
	<xsl:template match="produtos">
		
		<h2>Produtos</h2>
		
		<xsl:apply-templates select="produto"/>	
	
	</xsl:template>
	
	<xsl:template match="produto">
		
		<p>Nome: <xsl:value-of select="nome"/></p>
		<p>Preco: <xsl:value-of select="preco"/></p>
		<hr/>
			
	</xsl:template>
	
</xsl:stylesheet>