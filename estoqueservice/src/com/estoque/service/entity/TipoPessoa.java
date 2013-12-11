package com.estoque.service.entity;

import java.util.ArrayList;
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
@Table(name = "TIPO_PESSOA")
@XmlRootElement


public class TipoPessoa {
	@Id
	@GeneratedValue
	@Column(name="COD_TIPO_PESSOA")
	private int id;
	@Column(name="TIPO_PESSOA")
	private String tipo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="pessoaTipo")
	private List<Pessoa> pessoa = new ArrayList<Pessoa>();


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo_pessoa() {
		return tipo;
	}
	public void setTipo_pessoa(String tipo_pessoa) {
		this.tipo = tipo_pessoa;
	}
	
	
}
