package com.stefanini.hackaton.persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;

import com.stefanini.hackaton.entities.Personagem;
import com.stefanini.hackaton.parsers.JogadorParserDTO;

public class PersonagemDAO 
		extends GenericDAO<Integer, Personagem> {
	
	@PersistenceContext(unitName = "mariokartUnit")
	private EntityManager em;
	
	@Inject
	JogadorParserDTO parser;
	
	public Personagem findByIdPersonagem(Integer p) {
		try {
			Personagem personagem = (Personagem)em
					.createNamedQuery("Personagem.getEspecificPersonagem")
					.setParameter("idPersonagem", p.intValue())
					.getSingleResult();
			return personagem;

		} catch (Exception e2) {
			System.out.println(e2);
			return new Personagem();
		}
	}

}
