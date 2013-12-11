package com.estoque.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
	@POST
	@Path("/remove")
	public void removeCategoria(@FormParam("id") int id){
		new CategoriaImpl().delete(id);
	}
	
	@POST
	@Path("/removeList")
	public void removeLisCategoria(@FormParam("id") List<Integer> id){
		
		new CategoriaImpl().deleteList(id);
	}
	
	@POST
	@Path("/update")
	@Produces("application/json")
	public String updateCategoria(@FormParam("id") int id, @FormParam("descricao") String descricao){
		Categoria cat = new Categoria();
		cat.setId(id);
		cat.setDescricao(descricao);
		return new CategoriaImpl().update(cat);
	}
	
	@POST
	@Path("/save")
	public String saveCategoria(@FormParam("categoria") Categoria categoria){
		Categoria cat = new Categoria();
		cat.setDescricao(categoria.getDescricao());
		return new CategoriaImpl().save(cat);
	}
}
