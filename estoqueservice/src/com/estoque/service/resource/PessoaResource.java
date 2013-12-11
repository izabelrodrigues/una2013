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

import com.estoque.service.entity.Pessoa;
import com.estoque.service.interfaces.implementacoes.PessoaImpl;

@Path("/pessoas")
public class PessoaResource {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Pessoa> listAll(){
		return new PessoaImpl().listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Pessoa getPessoa(@PathParam("id") int id){
		return  new PessoaImpl().findById(id);
	}
	
	@POST
	@Path("/remove")
	public void removePessoa(@FormParam("id") int id){
		new PessoaImpl().delete(id);
	}
	
	@POST
	@Path("/update")
	public void updateCategoria(@FormParam("id") int id,@FormParam("nome") String nome, @FormParam("cpfcnpj") String cpfcnpj, @FormParam("telefone") String telefone, @FormParam("email") String email, @FormParam("endereco") String endereco, @FormParam("cep") String cep, @FormParam("grupo") String grupo){
		Pessoa pa = new Pessoa();
		pa.setId(id);
		pa.setNome(nome);
		pa.setCpfcnpj(cpfcnpj);
		pa.setTelefone(telefone);
		pa.setEmail(email);
		pa.setEndereco(endereco);
		pa.setCep(cep);
		pa.setGrupo(grupo);
		new PessoaImpl().update(pa);
	}
	
	@POST
	@Path("/save")
	public void saveCategoria(@FormParam("nome") String nome, @FormParam("cpfcnpj") String cpfcnpj, @FormParam("telefone") String telefone, @FormParam("email") String email, @FormParam("endereco") String endereco, @FormParam("cep") String cep, @FormParam("grupo") String grupo){
		Pessoa pa = new Pessoa();
		pa.setNome(nome);
		pa.setCpfcnpj(cpfcnpj);
		pa.setTelefone(telefone);
		pa.setEmail(email);
		pa.setEndereco(endereco);
		pa.setCep(cep);
		pa.setGrupo(grupo);
		new PessoaImpl().save(pa);
	}
	
}
