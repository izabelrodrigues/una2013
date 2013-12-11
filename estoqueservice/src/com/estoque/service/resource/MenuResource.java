package com.estoque.service.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.estoque.service.entity.Menu;

@Path("/menu")
public class MenuResource {
	@GET
	@Path("default")
	public Menu geraMenu(){
		return new Menu();
	}

}
