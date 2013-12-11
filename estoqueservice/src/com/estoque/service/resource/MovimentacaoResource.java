package com.estoque.service.resource;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.estoque.service.entity.Movimentacao;
import com.estoque.service.interfaces.implementacoes.MovimentacaoImpl;

@Path("/movimentos")
public class MovimentacaoResource {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Movimentacao> listAll(){
		return new MovimentacaoImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Movimentacao getMovimentacao(@PathParam("id") int id){
		return  new MovimentacaoImpl().findById(id);
	}
	
	@POST
	@Path("/remove")
	public void removeMovimentacao(@FormParam("id") int id){
		new MovimentacaoImpl().delete(id);
	}
	
	@POST
	@Path("/update")
	public void updateMovimentacao(@FormParam("id") int id, @FormParam("data") Date data, @FormParam("tipoMovimento") int tipoMovimento){
		Movimentacao mov = new Movimentacao();
		mov.setId(id);
		mov.setData(data);
		new MovimentacaoImpl().update(mov);
	}
	
	@POST
	@Path("/save")
	public void saveMovimentacao( @FormParam("data") Date data, @FormParam("movimento") String movimento){
		Movimentacao mov = new Movimentacao();
		mov.setData(data);
		new MovimentacaoImpl().save(mov);
	}
	
}
