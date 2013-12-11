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
@Table(name = "TIPO_MOVIMENTACAO")
@XmlRootElement
public class TipoMovimento {
	@Id
	@GeneratedValue
	@Column(name="COD_TIPO_MOVIMENTACAO")
	private int id;
	@Column(name="MOVIMENTO")
	private String movimento;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="tipoMovimento")
	private Collection<Movimentacao> mov ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}


}
