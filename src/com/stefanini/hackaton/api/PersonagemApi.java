package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
}
