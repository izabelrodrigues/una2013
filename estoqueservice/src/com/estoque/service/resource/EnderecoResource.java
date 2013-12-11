package com.estoque.service.resource;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.estoque.service.entity.Endereco;
import com.estoque.service.interfaces.implementacoes.EnderecoImpl;

@Path("/enderecos")
public class EnderecoResource {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Endereco> listAll(){
		return new EnderecoImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Endereco getEndereco(@PathParam("id") int id){
		return  new EnderecoImpl().findById(id);
	}
	
	@POST
	@Path("/remove")
	public void removeEndereco(@FormParam("id") int id){
		new EnderecoImpl().delete(id);
	}
	
	@POST
	@Path("/update")
	public void updateEndereco(@FormParam("id") int id, @FormParam("logradouro") String logradouro, @FormParam("numero") int numero, @FormParam("complemento") String complemento, @FormParam("bairro") String bairro, @FormParam("cep") String cep){
		Endereco end = new Endereco();
		end.setId(id);
		end.setLogradouro(logradouro);
		end.setNumero(numero);
		end.setComplemento(complemento);
		end.setBairro(bairro);
		end.setCep(cep);
		new EnderecoImpl().update(end);
	}
	
	@POST
	@Path("/save")
	public void saveEndereco( @FormParam("logradouro") String logradouro, @FormParam("numero") int numero, @FormParam("complemento") String complemento, @FormParam("bairro") String bairro, @FormParam("cep") String cep){
		Endereco end = new Endereco();
		end.setLogradouro(logradouro);
		end.setNumero(numero);
		end.setComplemento(complemento);
		end.setBairro(bairro);
		end.setCep(cep);
		new EnderecoImpl().save(end);
	}
	
	
}
