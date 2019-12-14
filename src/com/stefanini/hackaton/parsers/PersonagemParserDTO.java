package com.stefanini.hackaton.parsers;

import java.util.ArrayList;
import java.util.List;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.entities.Personagem;

public class PersonagemParserDTO extends AbstractParser<PersonagemDto, Personagem> {
	
	@Override
	public PersonagemDto toDTO(Personagem entity) {
		PersonagemDto dto = new PersonagemDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setAceleracao(entity.getAceleracao());
		dto.setManobra(entity.getManobra());
		dto.setPeso(entity.getPeso());
		dto.setTracao(entity.getTracao());
		dto.setTurbo(entity.getTurbo());
		dto.setVelocidade(entity.getVelocidade());
		dto.setJogadores(new ArrayList<>());
		
		return dto;
	}
	
	public PersonagemDto getJogadoresDoPersonagem(Personagem entity, PersonagemDto dto) {
		for (Jogador jogador : entity.getJogadores()) {
			JogadorDto jDto = new JogadorDto();
			jDto.setId(jogador.getId());
			jDto.setNickname(jogador.getNickname());
			jDto.setIdPersonagem(entity.getId());
			
			dto.getJogadores().add(jDto);
		}
		return dto;
	}

	@Override
	public Personagem toEntity(PersonagemDto dto) {
		Personagem entity = new Personagem();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setAceleracao(dto.getAceleracao());
		entity.setManobra(dto.getManobra());
		entity.setPeso(dto.getPeso());
		entity.setTracao(dto.getTracao());
		entity.setTurbo(dto.getTurbo());
		entity.setVelocidade(dto.getVelocidade());
		return entity;
	}
	
	public PersonagemDto toDTOPersonagem(Personagem entity) {
		PersonagemDto dto = new PersonagemDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setAceleracao(entity.getAceleracao());
		dto.setManobra(entity.getManobra());
		dto.setPeso(entity.getPeso());
		dto.setTracao(entity.getTracao());
		dto.setTurbo(entity.getTurbo());
		dto.setVelocidade(entity.getVelocidade());
		dto.setJogadores(new ArrayList<>());
		
		return dto;
	}


}
