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
@Table(name = "ENDERECO")
@XmlRootElement


public class Endereco {

	@Id
	@GeneratedValue
	@Column(name="COD_ENDERECO")
	private int id;
	@Column(name="LOGRADOURO")
	private String logradouro;
	@Column(name="NUMERO")
	private int numero;
	@Column(name="COMPLEMENTO")
	private String complemento;
	@Column(name="BAIRRO")
	private String bairro;
	@Column(name="CEP")
	private String cep;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CIDADE")
	private Cidade cidadeEndereco;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ESTADO")
	private Estado estadoEndereco;*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PAIS")
	private Pais paisEndereco;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="enderecoPessoa")
	private List<Pessoa> pessoa = new ArrayList<Pessoa>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidadeEndereco() {
		return cidadeEndereco;
	}

	public void setCidadeEndereco(Cidade cidadeEndereco) {
		this.cidadeEndereco = cidadeEndereco;
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
}
