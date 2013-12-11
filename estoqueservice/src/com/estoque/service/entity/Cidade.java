package com.estoque.service.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CIDADE")
@XmlRootElement

public class Cidade {

	@Id
	@Column(name = "COD_CIDADE")
	private int id;
	@Column(name = "DESC_CIDADE")
	private String cidade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ESTADO")
	private Cidade cidadeEstado;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="cidadeEndereco")
	private List<Endereco> listaEndereco = new ArrayList<Endereco>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public Cidade getCidadeEstado() {
		return cidadeEstado;
	}


	public void setCidadeEstado(Cidade cidadeEstado) {
		this.cidadeEstado = cidadeEstado;
	}


	public List<Endereco> getListaEndereco() {
		return listaEndereco;
	}


	public void setListaEndereco(List<Endereco> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}
	
	
	
}
