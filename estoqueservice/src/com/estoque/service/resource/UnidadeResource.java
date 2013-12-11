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

import com.estoque.service.entity.Unidade;
import com.estoque.service.interfaces.implementacoes.UnidadeImpl;

@Path("/medidas")
public class UnidadeResource {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Unidade> listAll() {
		return new UnidadeImpl().listAll();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Unidade getUnidade(@PathParam("id") int id) {
		return new UnidadeImpl().findById(id);
	}

	@POST
	@Path("/remove")
	@Produces("application/json")
	public void removeUnidade(@FormParam("id") int id) {
		new UnidadeImpl().delete(id);
	}

	@POST
	@Path("/update")
	@Produces("application/json")
	public String updateUnidade(@FormParam("id") int id, @FormParam("unidade") String unidade) {
		Unidade unidadeMedida = new Unidade();
		unidadeMedida.setId(id);
		unidadeMedida.setUnidade(unidade);
		return new UnidadeImpl().update(unidadeMedida);
	}

	@POST
	@Path("/save")
	public String saveUnidade(@FormParam("id") int id, @FormParam("medida") String medida) {
		Unidade unidadeMedida = new Unidade();
		unidadeMedida.setUnidade(medida);
		return new UnidadeImpl().save(unidadeMedida);
	}

}
