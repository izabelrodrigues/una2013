package com.estoque.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ESTADO")
@XmlRootElement
public class Estado {

	@Id
	@Column(name = "COD_ESTADO")
	private int id;
	@Column(name = "ESTADO_SIGLA")
	private String sigla;
	@Column(name = "DESC_ESTADO")
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PAIS")
	private Pais codPais;
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy="estadoEndereco")
	private Collection<Endereco> listaEndereco;*/
	

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

	public Pais getCodPais() {
		return codPais;
	}

	public void setCodPais(Pais codPais) {
		this.codPais = codPais;
	}

}
