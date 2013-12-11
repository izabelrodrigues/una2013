package com.estoque.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "PESSOA")
@XmlRootElement

public class Pessoa {

	@Id
	@GeneratedValue
	@Column(name="COD_PESSOA")
	private int id;
	@Column(name="NOME")
	private String nome;
	@Column(name="CPFCNPJ")
	private String cpfcnpj;
	@Column(name="TELEFONE")
	private String telefone;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ENDERECO")
	private String endereco;
	@Column(name="CEP")
	private String cep;
	@Column(name="GRUPO")
	private String grupo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_USUARIO")
	private Usuario usuarioPessoas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_TIPO_PESSOA")
	private TipoPessoa pessoaTipo;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ENDERECO")
	private Endereco enderecoPessoa;*/
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy="movPessoa")
	private Collection<Movimentacao> mov ;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	
}
