package com.stefanini.hackaton.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;
import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.entities.Personagem;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.parsers.PersonagemParserDTO;
import com.stefanini.hackaton.persistence.JogadorDAO;
import com.stefanini.hackaton.persistence.PersonagemDAO;

public class JogadorService {

	@Inject
	JogadorParserDTO parser;

	@Inject
	JogadorDAO jogadorDao;

	@GET
	@Path("/jogador")
	@Transactional
	public List<JogadorDto> listar() {
		return parser.toDTO(jogadorDao.list());
	}

	@Transactional
	public JogadorDto obter(Integer id) {
		return parser.toDTO(jogadorDao.findById(id));
	}

	@Transactional
	public String inserir(JogadorDto dto) {

		try {
			
			if(dto.getSenha().length() > 5 && dto.getSenha().length() < 9) {
				if(verificarUser(dto) == false) {
					if(dto.getIdPersonagem() != null) {
						if(!dto.getNickname().equalsIgnoreCase("")) {
							System.out.println(dto.getNickname() + "nome do jogador");
							MessageDigest digest = MessageDigest.getInstance("SHA-256");
							byte messageDigest[] = digest.digest(dto.getSenha().getBytes("UTF-8"));

							StringBuilder builder = new StringBuilder();

							for (byte b : messageDigest) {
								builder.append(String.format("%02X", 0xFF & b));
							}

							String senhaHex = builder.toString();
							dto.setSenha(senhaHex);
							
							Jogador jogador = parser.toEntity(dto);
							jogadorDao.insert(jogador);
							return("cadastrado com sucesso!");
						}else {
							return("Nick invalida");
						}
					}else {
						return("escolha um personagem!");
					}
				}else {
					return("Usuario ja existente");
				}
				
			}else {
				return("Senha invalida");
			}

		} catch (Exception e) {
			Gson g = new Gson();
			return g.toJson(toString());
		}

		
	}

	@Transactional
	public JogadorDto alterar(Integer id, JogadorDto dto) {

		Jogador jogador = jogadorDao.findById(id);
		jogador.setId(dto.getId());
		jogador.setNickname(dto.getNickname());

		jogadorDao.update(jogador);

		return dto;
	}

	@Transactional
	public void excluir(Integer id) {
		jogadorDao.removeById(id);
	}

	@Transactional
	public JogadorDto listarPorJogador(Integer id) {
		Jogador jogador = jogadorDao.findById(id);
		jogador.getPersonagem().getId();
		return parser.toDTO(jogador);
	}

	@Transactional
	public JogadorDto verificarLogin(JogadorDto dto) {
		if(!dto.getNickname().equalsIgnoreCase("")) {
			if(!dto.getSenha().equalsIgnoreCase("")) {
				try {

					MessageDigest digest = MessageDigest.getInstance("SHA-256");
					byte messageDigest[] = digest.digest(dto.getSenha().getBytes("UTF-8"));

					StringBuilder builder = new StringBuilder();

					for (byte b : messageDigest) {
						builder.append(String.format("%02X", 0xFF & b));
					}

					String senhaHex = builder.toString();
					dto.setSenha(senhaHex);

				} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {

					System.out.println("Erro ao criptografar senha: " + e);
				}

				Jogador jogador = parser.toEntity(dto);
				jogador = jogadorDao.getLogin(jogador);
				if(jogador == null) {
					return new JogadorDto();
				}
				dto = parser.toDTO(jogador);
				dto.setSenha(null);
				return dto;
			}else {
				return dto;
			}
		}else {
			return dto;
		}
		
	}
	


	@Transactional
	public boolean verificarUser(JogadorDto dto) {

		Jogador jogador = parser.toEntity(dto);
		return jogadorDao.getUser(jogador);
	}

}
