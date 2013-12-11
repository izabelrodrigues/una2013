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

import com.estoque.service.entity.Categoria;
import com.estoque.service.entity.Usuario;
import com.estoque.service.interfaces.implementacoes.CategoriaImpl;
import com.estoque.service.interfaces.implementacoes.UsuarioImpl;

@Path("/usuarios")

public class UsuarioResource {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Usuario> listAll(){
		return new UsuarioImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Usuario getUsuario(@PathParam("id") int id){
		return  new UsuarioImpl().findById(id);
	}
	
	@POST
	@Path("/remove")
	@Produces("application/json")
	public void removeUsuario(@FormParam("id") int id){
		new UsuarioImpl().delete(id);
	}
	
	@POST
	@Path("/update")
	public void updateCategoria(@FormParam("id") int id,  @FormParam("login") String login, @FormParam("password") String password,@FormParam("status") String status){
		Usuario usr = new Usuario();
		usr.setId(id);
		usr.setLogin(login);
		usr.setPassword(password);
		usr.setStatus(status);
		new UsuarioImpl().update(usr);
	}
	
	@POST
	@Path("/save")
	public void saveUsuario(@FormParam("login") String login, @FormParam("password") String password,@FormParam("status") String status){
		Usuario usr = new Usuario();
		usr.setLogin(login);
		usr.setPassword(password);
		usr.setStatus(status);
		new UsuarioImpl().save(usr);
	}
	
}
