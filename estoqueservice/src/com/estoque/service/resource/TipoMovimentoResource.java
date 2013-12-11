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

import com.estoque.service.entity.TipoMovimento;
import com.estoque.service.interfaces.implementacoes.TipoMovimentoImpl;

@Path("/tipomov")
public class TipoMovimentoResource {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<TipoMovimento> listAll(){
		return new TipoMovimentoImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public TipoMovimento getTipoMovimento(@PathParam("id") int id){
		return  new TipoMovimentoImpl().findById(id);
	}
	
	@POST
	@Path("/remove")
	public void removeTipoMovimento(@FormParam("id") int id){
		new TipoMovimentoImpl().delete(id);
	}
	
	@POST
	@Path("/update")
	public void updateTipoMovimento(@FormParam("id") int id,@FormParam("movimento") String movimento){
		TipoMovimento tm = new TipoMovimento();
		tm.setId(id);
		tm.setMovimento(movimento);
		new TipoMovimentoImpl().update(tm);
	}
	
	@POST
	@Path("/save")
	public void saveTipoMovimento(@FormParam("movimento") String movimento){
		TipoMovimento tm = new TipoMovimento();
		tm.setMovimento(movimento);
		new TipoMovimentoImpl().save(tm);
	}
	
}
