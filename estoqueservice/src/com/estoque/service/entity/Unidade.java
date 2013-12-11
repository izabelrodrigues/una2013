package com.estoque.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "UNIDADE_MEDIDA")
@XmlRootElement
public class Unidade {
	@Id
	@GeneratedValue
	@Column(name = "COD_UNIDADE")
	private int id;
	@Column(name = "UNIDADE")
	private String unidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

}
