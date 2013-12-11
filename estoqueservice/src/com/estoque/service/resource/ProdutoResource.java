package com.estoque.service.resource;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.estoque.service.entity.Categoria;
import com.estoque.service.entity.Produto;
import com.estoque.service.entity.Unidade;
import com.estoque.service.interfaces.implementacoes.ProdutoImpl;
@Path("/produtos")
public class ProdutoResource {
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Produto> listAll(){
		return new ProdutoImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Produto getProduto(@PathParam("id") int id){
		return  new ProdutoImpl().findById(id);
	}
	
	@POST
	@Path("/remove")
	@Produces("application/json")
	public void removeProduto(@FormParam("id") int id){
		new ProdutoImpl().delete(id);
	}
	
	@POST
	@Path("/update")
	public void updateProduto(@FormParam("descricao") String descricao,
			@FormParam("estoqueMinimo") int estoqueMinimo,
			@FormParam("estoqueAtual") int estoqueAtual,
			@FormParam("estoqueMaximo") int estoqueMaximo,
			@FormParam("precoCompra") double precoCompra,
			@FormParam("precoVenda") double precoVenda,
			@FormParam("status") String status,
			@FormParam("categoriaProduto") int categoriaProduto,
			@FormParam("medidaProduto") int medidaProduto) {
		Produto produto = new Produto();
		produto.setDescricao(descricao);
		produto.setEstoqueMinimo(estoqueMinimo);
		produto.setEstoqueAtual(estoqueAtual);
		produto.setEstoqueMaximo(estoqueMaximo);
		produto.setPrecoCompra(precoCompra);
		produto.setPrecoVenda(precoVenda);
		produto.setStatus(status);
		Categoria cat = new Categoria();
		cat.setId(categoriaProduto);
		produto.setCategoriaProduto(cat);
		Unidade unidade = new Unidade();
		unidade.setId(medidaProduto);
		produto.setMedidaProduto(unidade);

		/*
		 * cat.setEstoqueMinimo(3); cat.setEstoqueAtual(5);
		 * cat.setEstoqueMaximo(5); Unidade u = new Unidade(); u.setId(1);
		 * Categoria c = new Categoria(); c.setId(1); cat.setMedidaProduto(u);
		 * cat.setCategoriaProduto(c); cat.setPrecoCompra(10.0);
		 * cat.setPrecoVenda(20.0); cat.setStatus("D");
		 */
		new ProdutoImpl().update(produto);
	}
	
	@POST
	@Path("/save")
	public void saveProduto(@FormParam("descricao") String descricao,
			@FormParam("estoqueMinimo") int estoqueMinimo,
			@FormParam("estoqueAtual") int estoqueAtual,
			@FormParam("estoqueMaximo") int estoqueMaximo,
			@FormParam("precoCompra") double precoCompra,
			@FormParam("precoVenda") double precoVenda,
			@FormParam("status") String status,
			@FormParam("categoriaProduto") int categoriaProduto,
			@FormParam("medidaProduto") int medidaProduto) {
		Produto produto = new Produto();
		produto.setDescricao(descricao);
		produto.setEstoqueMinimo(estoqueMinimo);
		produto.setEstoqueAtual(estoqueAtual);
		produto.setEstoqueMaximo(estoqueMaximo);
		produto.setPrecoCompra(precoCompra);
		produto.setPrecoVenda(precoVenda);
		produto.setStatus(status);
		Categoria cat = new Categoria();
		cat.setId(categoriaProduto);
		produto.setCategoriaProduto(cat);
		Unidade unidade = new Unidade();
		unidade.setId(medidaProduto);
		produto.setMedidaProduto(unidade);

		/*
		 * Teste para inserir
		 * cat.setEstoqueMinimo(3); cat.setEstoqueAtual(5);
		 * cat.setEstoqueMaximo(5); Unidade u = new Unidade(); u.setId(1);
		 * Categoria c = new Categoria(); c.setId(1); cat.setMedidaProduto(u);
		 * cat.setCategoriaProduto(c); cat.setPrecoCompra(10.0);
		 * cat.setPrecoVenda(20.0); cat.setStatus("D");
		 */
		new ProdutoImpl().save(produto);
	}

}
