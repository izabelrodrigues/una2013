package com.estoque.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.estoque.service.entity.Categoria;
import com.estoque.service.interfaces.implementacoes.CategoriaImpl;

@Path("/categorias")
public class CategoriaResource {

	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Categoria> listAll(){
		return new CategoriaImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Categoria getCategoria(@PathParam("id") int id){
		return  new CategoriaImpl().findById(id);
	}
	
	@DELETE
	@Path("/remove/{id}")
	@Produces("application/json")
	public void removeCategoria(@PathParam("id") int id){
		new CategoriaImpl().delete(id);
	}
	
	@PUT
	@Path("/{id}/{descricao}")
	public void updateCategoria(@PathParam("id") int id, @PathParam("descricao") String descricao){
		Categoria cat = new Categoria();
		cat.setId(id);
		cat.setDescricao(descricao);
		new CategoriaImpl().update(cat);
	}
	
	@POST
	@Path("/save/{descricao}")
	@Consumes("application/json")
	public void saveCategoria(@PathParam("descricao") String descricao){
		Categoria cat = new Categoria();
		cat.setDescricao(descricao);
		new CategoriaImpl().save(cat);
	}
}
