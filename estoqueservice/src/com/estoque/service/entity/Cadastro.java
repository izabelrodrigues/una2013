package com.estoque.service.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cadastro {
	
	private String Categorias;
	private String Fornecedores;
	private String Medidas;
	public String getCategorias() {
		return Categorias;
	}
	public void setCategorias(String categorias) {
		Categorias = categorias;
	}
	public String getFornecedores() {
		return Fornecedores;
	}
	public void setFornecedores(String fornecedores) {
		Fornecedores = fornecedores;
	}
	public String getMedidas() {
		return Medidas;
	}
	public void setMedidas(String medidas) {
		Medidas = medidas;
	}

	
}
