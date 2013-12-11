package com.estoque.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "MOVIMENTACAO_ITEM")
@XmlRootElement

public class MovimentoItem {


	@GeneratedValue
	@Column(name="QUANTIDADE")
	private int quantidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOVIMENTACAO_ID")
	private Movimentacao idMovimentacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUTO_ID")
	private Produto idProduto;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Movimentacao getIdMovimentacao() {
		return idMovimentacao;
	}

	public void setIdMovimentacao(Movimentacao idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}


	
		
}
