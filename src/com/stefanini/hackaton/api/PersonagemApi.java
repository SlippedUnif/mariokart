package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.service.PersonagemService;

@Path("/personagem")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonagemApi {
	

	@Inject
	private PersonagemService personagemService;

	@GET
	public Response listar() {
		return Response.ok(personagemService.listar()).build();
	}
	
	@GET
	@Path("/jogadores/{id}")
	public Response listarPorPersonagem(@PathParam("id") Integer id) {
		return Response.ok(personagemService.listarPorPersonagem(id)).build();
	}
	
	@GET
	@Path("/{id}")
	public Response obter(@PathParam("id") Integer id) {
		return Response.ok(personagemService.obter(id)).build();
	}
	
	@POST
	public Response inserir(PersonagemDto dto) {
		return Response.ok(personagemService.inserir(dto)).build();
	}
	
	
	@PUT
	@Path("/{id}")
	public Response alterar(PersonagemDto dto, 
			@PathParam("id") Integer id) {
		return Response.ok(personagemService.alterar(id, dto)).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response excluir(@PathParam("id") Integer id) {
		personagemService.excluir(id);
		return Response.ok().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
