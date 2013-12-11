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

import com.estoque.service.entity.Pais;
import com.estoque.service.interfaces.implementacoes.PaisImpl;;

@Path("/paises")
public class PaisResource {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Pais> listAll(){
		return new PaisImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Pais getCategoria(@PathParam("id") int id){
		return  new PaisImpl().findById(id);
	}
	
	@POST
	@Path("/remove")
	public void removePais(@FormParam("id") int id){
		new PaisImpl().delete(id);
	}
	
	@POST
	@Path("/update")
	public void updateCategoria(@FormParam("id") int id,@FormParam("sigla") String sigla, @FormParam("descricao") String descricao){
		Pais pa = new Pais();
		pa.setId(id);
		pa.setSigla(sigla);
		pa.setDescricao(descricao);
		new PaisImpl().update(pa);
	}
	
	@POST
	@Path("/save")
	public void saveCategoria(@FormParam("sigla") String sigla,@FormParam("descricao") String descricao){
		Pais pa = new Pais();
		pa.setSigla(sigla);
		pa.setDescricao(descricao);
		new PaisImpl().save(pa);
	}
	
}
