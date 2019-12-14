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

import com.google.gson.Gson;
import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.service.JogadorService;
import com.stefanini.hackaton.service.PersonagemService;

@Path("/jogadores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorApi {
	

	@Inject
	private JogadorService jogadoresService;
	
	@Inject
	private PersonagemService personagemService;
	
	
	

	@GET
	public Response listar() {
		return Response.ok(jogadoresService.listar()).build();
	}
	
	@GET
	@Path("/jogadores/{id}")
	public Response listarPorJogadores(@PathParam("id") Integer id) {
		return Response.ok(jogadoresService.listarPorJogador(id)).build();
	}
	
	@GET
	@Path("/{id}")
	public Response obter(@PathParam("id") Integer id) {
		return Response.ok(jogadoresService.obter(id)).build();
	}
	
	@POST
	@Path("/{json}")
	public Response inserir(@PathParam("json")String json) {
		Gson gson = new Gson();
		JogadorDto dto = gson.fromJson(json, JogadorDto.class);
		return Response.ok(gson.toJson(jogadoresService.inserir(dto))).build();
	}
	
	
	@PUT
	@Path("/{id}")
	public Response alterar(JogadorDto dto, 
			@PathParam("id") Integer id) {
		return Response.ok(jogadoresService.alterar(id, dto)).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response excluir(@PathParam("id") Integer id) {
		jogadoresService.excluir(id);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/getLogin/{json}")
	public Response getLogin(@PathParam("json")String json) {
		Gson gson = new Gson();
		JogadorDto dto = gson.fromJson(json, JogadorDto.class);
		return Response.ok(jogadoresService.verificarLogin(dto)).build();
	}
	
}
