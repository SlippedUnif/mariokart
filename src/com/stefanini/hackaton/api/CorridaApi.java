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
import com.stefanini.hackaton.entities.Corrida;
import com.stefanini.hackaton.service.CorridaService;
import com.stefanini.hackaton.service.JogadorService;
import com.stefanini.hackaton.service.PersonagemService;

@Path("/corrida")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorridaApi {
	

	@Inject
	private JogadorService jogadoresService;
	
	@Inject
	private PersonagemService personagemService;
	
	@Inject
	private CorridaService corridaService;
	

	@GET
	@Path("/getConcorrentes")
	public Response getConcorrentes(JogadorDto dto) {
		return Response.ok(corridaService.getConcorrentes(dto)).build();
	}
	
	@GET
	@Path("/initCorrida/{json}")
	public Response initCorrinda(@PathParam("json") String json) {
		System.out.println(json);
		Gson gson = new Gson();
		Corrida corrida = gson.fromJson(json, Corrida.class);
		return Response.ok(corridaService.initCorrida(corrida)).build();
	}
}
