package com.estoque.service.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PAIS")
@XmlRootElement
public class Pais {
	@Id
	@GeneratedValue
	@Column(name = "COD_PAIS")
	private int id;
	@Column(name = "SGL_PAIS")
	private String sigla;
	@Column(name = "DESC_PAIS")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="codPais")
	private Collection<Estado> listaEstados;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
