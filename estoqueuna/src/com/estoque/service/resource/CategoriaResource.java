package com.estoque.service.resource;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.estoque.service.entity.Categoria;
import com.estoque.service.interfaces.implementacoes.CategoriaImpl;

@Path("/categoria")
public class CategoriaResource {

	@GET
	@Path("/listar")
	@Produces("application/json")
	public Set<Categoria> listAll(){
		return new CategoriaImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Categoria getCategoria(@PathParam("id") int id){
		return  new CategoriaImpl().findById(id);
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public void removerCategoria(@PathParam("id") int id){
		new CategoriaImpl().delete(id);
	}
}
