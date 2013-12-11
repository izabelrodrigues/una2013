package com.estoque.service.entity;



import java.util.Collection;
import java.util.Date;

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
@Table(name = "MOVIMENTACAO")
@XmlRootElement

public class Movimentacao {

	@Id
	@GeneratedValue
	@Column(name="COD_MOVIMENTACAO")
	private int id;
	
	@Column(name="DATA_MOVIMENTACAO")
	private Date data;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_MOVIMENTACAO")
	private TipoMovimento tipoMovimento;
	
	/*
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PESSOA")
	private Pessoa movPessoa;*/
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="movItem")
	private Collection<MovimentoItem> movi ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	/*public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}*/

	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}
	
	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

/*
	
	public Pessoa getMovPessoa() {
		return movPessoa;
	}

	public void setMovPessoa(Pessoa movPessoa) {
		this.movPessoa = movPessoa;
	}

	public Collection<MovimentoItem> getMovi() {
		return movi;
	}

	public void setMovi(Collection<MovimentoItem> movi) {
		this.movi = movi;
	}
	*/
	

}
