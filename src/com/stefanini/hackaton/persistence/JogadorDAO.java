package com.stefanini.hackaton.persistence;

import java.awt.JobAttributes;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.entities.Personagem;
import com.stefanini.hackaton.parsers.JogadorParserDTO;

public class JogadorDAO extends GenericDAO<Integer, Jogador>{

	@PersistenceContext(unitName = "mariokartUnit")
	private EntityManager em;
	
	@Inject
	JogadorParserDTO parser;
	
	private Class<Jogador> clazz;
	
	public Jogador getLogin(Jogador e) {
		Jogador jogador = null;
		
		try {
			jogador = (Jogador) em.createNamedQuery("Jogador.getLogin")
					.setParameter("nickname", e.getNickname())
					.setParameter("senha", e.getSenha())
					.getSingleResult();
			

		} catch (Exception e2) {
			return jogador;
		}
		return jogador;
	}
	
	public boolean getUser(Jogador e) {
		Jogador jogador = new Jogador();
		
		try {
			if(em.createNamedQuery("Jogador.getUser")
					.setParameter("nickname", e.getNickname())
					.getSingleResult() != null) {

				return true;
			}else {
				return false;
			}

		} catch (Exception e2) {
			return false;
		}
		
	}
}
