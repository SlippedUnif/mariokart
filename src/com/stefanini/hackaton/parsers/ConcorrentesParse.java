package com.stefanini.hackaton.parsers;

import javax.inject.Inject;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.entities.Concorrente;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.entities.Personagem;

public class ConcorrentesParse extends AbstractParser<Concorrente, Jogador>{
	@Inject
	PersonagemParserDTO personagemParseDto;
	@Inject
	JogadorParserDTO jogadorParseDto;

	
	public Concorrente toConcorrente(JogadorDto jogadorDto, PersonagemDto personagemDto) {
		Concorrente concorrente = new Concorrente();
		concorrente.setNickname(jogadorDto.getNickname());
		concorrente.setPersonagemdto(personagemDto);
		return concorrente;
	}

	@Override
	public Jogador toEntity(Concorrente dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Concorrente toDTO(Jogador entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Concorrente toConcorrenteCPU(PersonagemDto personagemDto) {
		Concorrente concorrente = new Concorrente();
		concorrente.setNickname("CPU>" + personagemDto.getNome());
		concorrente.setPersonagemdto(personagemDto);
		return concorrente;
	}
}
