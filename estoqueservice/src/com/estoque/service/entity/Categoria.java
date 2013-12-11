package com.estoque.service.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CATEGORIA")
@XmlRootElement
public class Categoria {

	@Id
	@GeneratedValue
	@Column(name="COD_CATEGORIA")
	private int id;
	@Column(name="DESCRICAO")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="categoriaProduto")
	private Collection<Produto> produtos ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
