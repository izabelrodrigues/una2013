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
@Table(name = "PRODUTO")
@XmlRootElement
public class Produto {
	@Id
	@GeneratedValue
	@Column(name = "COD_PRODUTO")
	private int id;
	@Column(name = "DESCRICAO")
	private String descricao;
	@Column(name = "ESTOQUE_MINIMO")
	private int estoqueMinimo;
	@Column(name = "ESTOQUE_ATUAL")
	private int estoqueAtual;
	@Column(name = "ESTOQUE_MAXIMO")
	private int estoqueMaximo;
	@Column(name = "PRECO_COMPRA")
	private Double precoCompra;
	@Column(name = "PRECO_VENDA")
	private Double precoVenda;
	@Column(name = "STATUS")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CATEGORIA")
	private Categoria categoriaProduto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_UNIDADE_MEDIDA")
	private Unidade medidaProduto;

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

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public int getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public int getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Categoria getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(Categoria categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public Unidade getMedidaProduto() {
		return medidaProduto;
	}

	public void setMedidaProduto(Unidade medidaProduto) {
		this.medidaProduto = medidaProduto;
	}

}
