
package com.stefanini.hackaton.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.apache.openejb.quartz.simpl.RAMJobStore;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.entities.Concorrente;
import com.stefanini.hackaton.entities.Corrida;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.parsers.ConcorrentesParse;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.parsers.PersonagemParserDTO;

public class CorridaService {

	@Inject
	JogadorService jogadorService;

	@Inject
	PersonagemService personagemService;

	@Inject
	JogadorParserDTO parserJogador;

	@Inject
	PersonagemParserDTO parserPersonagem;

	@Inject
	ConcorrentesParse concorrenteParser;

	@GET
	@Path("/corrida")
	@Transactional
	public List<Concorrente> getConcorrentes(JogadorDto jogadorDto) {
		PersonagemDto personagemDto = personagemService.getEspecificPersonagem(jogadorDto.getIdPersonagem());
		List<Concorrente> concorrentes = new ArrayList<Concorrente>();
		concorrentes.add(concorrenteParser.toConcorrente(jogadorDto, personagemDto));

		for (PersonagemDto personagem : personagemService.listar()) {
			if (personagem.getId() != jogadorDto.getIdPersonagem()) {
				concorrentes.add(concorrenteParser.toConcorrenteCPU(personagem));
			}
		}

		return concorrentes;
	}

	public Corrida initCorrida(Corrida corrida) {
		Random random = new Random();
		JogadorDto jogadorDto = corrida.getJogadorDto();
		corrida.setConcorrentes(getConcorrentes(jogadorDto));
		corrida.setClassificacao(new ArrayList<Concorrente>());
		for (Concorrente concorrente : corrida.getConcorrentes()) {
			Double tempoCorrida = 0.0;
			PersonagemDto p = concorrente.getPersonagemdto();

			for (int i = 1; i <= corrida.getNumeroVoltas(); i++) {
				Integer aproveitamento = random.nextInt(50);
				for(;aproveitamento == 0 || aproveitamento < 20;) {
					aproveitamento = random.nextInt(50);
				}
				System.out.println("numero random = " + aproveitamento.intValue());
				tempoCorrida += (((((p.getVelocidade() + p.getAceleracao() / p.getPeso())) * p.getTurbo()) * corrida.getDistancia()) / aproveitamento) / 100000;
				System.out.println("tempo corrida volta " + i + " = " + tempoCorrida);

			}
			concorrente.setNotaCorrida(tempoCorrida);
			
			corrida.getClassificacao().add(concorrente);
			corrida.setConcorrentes(null);
			

		}
		corrida.setClassificacao(organizarLista(corrida.getClassificacao()));
		return corrida;
	}
	
	public List<Concorrente> organizarLista(List<Concorrente> concorrentes){
		
		for (int i = 0; i < concorrentes.size() - 1; i++) {
		     for (int j = 0; j < concorrentes.size() - 1; j++) {
		         if (concorrentes.get(j).getNotaCorrida() > concorrentes.get(j+1).getNotaCorrida()) {
		             troca(concorrentes, j, j + 1);
		         }
		     }
		 }
		
		return concorrentes;
	}
	
	private void troca(List<Concorrente> a, int i, int j) {

		 Concorrente temp = a.get(i);
		 a.set(i, a.get(j));
		 a.set(j, temp);
		}

}
