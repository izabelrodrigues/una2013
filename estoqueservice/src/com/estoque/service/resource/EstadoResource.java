package com.estoque.service.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.estoque.service.entity.Estado;
import com.estoque.service.interfaces.implementacoes.EstadoImpl;

@Path("/estados")
public class EstadoResource {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Estado> listAll(){
		return new EstadoImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Estado getEstado(@PathParam("id") int id){
		return  new EstadoImpl().findById(id);
	}
	
	@POST
	@Path("/remove")
	public void removeEstado(@FormParam("id") int id){
		new EstadoImpl().delete(id);
	}
	
	@POST
	@Path("/update")
	public void updateEstado(@FormParam("id") int id, @FormParam("sigla") String sigla, @FormParam("descricao") String descricao){
		Estado est = new Estado();
		est.setId(id);
		est.setSigla(sigla);
		est.setDescricao(descricao);
		new EstadoImpl().update(est);
	}
	
	@POST
	@Path("/save")
	public void saveCategoria( @FormParam("sigla") String sigla,@FormParam("descricao") String descricao){
		Estado est = new Estado();
		est.setSigla(sigla);
		est.setDescricao(descricao);
		new EstadoImpl().save(est);
	}
	
}
