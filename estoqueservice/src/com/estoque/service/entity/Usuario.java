package com.estoque.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "USUARIO")
@XmlRootElement
public class Usuario {
	@Id
	@GeneratedValue
	@Column(name="COD_USUARIO")
	private int id;
	@Column(name="LOGIN")
	private String login;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="STATUS")
	private String status;
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy="usuarioPessoas")
	private List<Pessoa> pessoa = new ArrayList<Pessoa>();*/

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public List<Pessoa> getPessoa() {
//		return pessoa;
//	}
//
//	public void setProdutos(List<Pessoa> pessoa) {
//		this.pessoa = pessoa;
//	}

}
