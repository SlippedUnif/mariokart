package com.stefanini.hackaton.service;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.parsers.HeroiParserDTO;
import com.stefanini.hackaton.persistence.PersonagemDAO;

public class PersonagemService {

	@Inject
	HeroiParserDTO parser;
	
	@Inject
	PersonagemDAO heroiDao;


	public List<PersonagemDto> listar() {
		return parser.toDTO(heroiDao.list());
	}

}
