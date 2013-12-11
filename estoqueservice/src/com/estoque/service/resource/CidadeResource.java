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

import com.estoque.service.entity.Cidade;
import com.estoque.service.interfaces.implementacoes.CidadeImpl;

@Path("/cidades")
public class CidadeResource {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Cidade> listAll(){
		return new CidadeImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Cidade getCidade(@PathParam("id") int id){
		return  new CidadeImpl().findById(id);
	}
	
	@POST
	@Path("/remove")
	public void removeCidade(@FormParam("id") int id){
		new CidadeImpl().delete(id);
	}
	
	@POST
	@Path("/update")
	public void updateCidade(@FormParam("id") int id, @FormParam("cidade") String cidade){
		Cidade cid = new Cidade();
		cid.setId(id);
		cid.setCidade(cidade);
		new CidadeImpl().update(cid);
	}
	
	@POST
	@Path("/save")
	public void saveCidade(@FormParam("cidade") String cidade){
		Cidade cid = new Cidade();
		cid.setCidade(cidade);
		new CidadeImpl().save(cid);
	}
	
}
