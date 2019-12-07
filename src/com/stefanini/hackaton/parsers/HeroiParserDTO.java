package com.stefanini.hackaton.parsers;

import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.entities.Personagem;

public class HeroiParserDTO extends AbstractParser<PersonagemDto, Personagem> {

	@Override
	public PersonagemDto toDTO(Personagem entity) {
		PersonagemDto dto = new PersonagemDto();
		dto.setId(null);
		dto.setNome(entity.getNome());
		dto.setAceleracao(null);
		dto.setManobra(null);
		dto.setPeso(null);
		dto.setTracao(null);
		dto.setTurbo(null);
		dto.setVelocidade(null);
		return dto;
	}

	@Override
	public Personagem toEntity(PersonagemDto dto) {
		Personagem entity = new Personagem();
		entity.setId(null);
		entity.setNome(dto.getNome());
		entity.setAceleracao(null);
		entity.setManobra(null);
		entity.setPeso(null);
		entity.setTracao(null);
		entity.setTurbo(null);
		entity.setVelocidade(null);
		return entity;
	}

}
