package com.stefanini.hackaton.parsers;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.entities.Personagem;

public class JogadorParserDTO extends AbstractParser<JogadorDto, Jogador>{

	@Override
	public JogadorDto toDTO(Jogador entity) {
		JogadorDto dto = new JogadorDto();
		dto.setId(entity.getId());
		dto.setIdPersonagem(entity.getPersonagem().getId());
		dto.setNickname(entity.getNickname());
		dto.setSenha(entity.getSenha());
		return dto;
	}

	@Override
	public Jogador toEntity(JogadorDto dto) {
		Jogador entity = new Jogador();
		entity.setId(dto.getId());
		entity.setPersonagem(new Personagem());
		entity.getPersonagem().setId(dto.getIdPersonagem());
		entity.setNickname(dto.getNickname());
		entity.setSenha(dto.getSenha());
		return entity;
	}

}
