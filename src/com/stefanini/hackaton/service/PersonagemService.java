package com.stefanini.hackaton.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.entities.Personagem;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.parsers.PersonagemParserDTO;
import com.stefanini.hackaton.persistence.PersonagemDAO;

public class PersonagemService {

	@Inject
	PersonagemParserDTO parser;
	
	@Inject
	PersonagemDAO personagemDao;

	@GET
	@Path("/personagem")
	@Transactional
	public List<PersonagemDto> listar() {
		return parser.toDTO(personagemDao.list());
	}

	@GET
	@Path("/personagem/{}")
	public PersonagemDto obter(Integer id) {
		return parser.toDTO(personagemDao.findByIdPersonagem(id));
	}


	public PersonagemDto inserir(PersonagemDto dto) {
		Personagem personagem = parser.toEntity(dto);
		personagemDao.insert(personagem);
		return dto;
	}


	public PersonagemDto alterar(Integer id, PersonagemDto dto) {
		Personagem personagem = personagemDao.findById(id);
		personagem.setAceleracao(dto.getAceleracao());
		personagem.setManobra(dto.getManobra());
		personagem.setNome(dto.getNome());
		personagem.setPeso(dto.getPeso());
		personagem.setTracao(dto.getTracao());
		personagem.setTurbo(dto.getTurbo());
		personagem.setVelocidade(dto.getVelocidade());
		
		personagemDao.update(personagem);
		
		return dto;
	}


	public void excluir(Integer id) {
		personagemDao.removeById(id);
	}


	@Transactional
	public PersonagemDto listarPorPersonagem(Integer id) {
		Personagem personagem = personagemDao.findByIdPersonagem(id);
		return parser.toDTOPersonagem(personagem);
	}
	
	@Transactional
	public PersonagemDto getEspecificPersonagem(Integer id) {
		Personagem personagem = personagemDao.findByIdPersonagem(id);
		return parser.toDTOPersonagem(personagem);
	}
	
	
	
	
	
	
	
	
	

}
