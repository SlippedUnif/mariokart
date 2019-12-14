package com.stefanini.hackaton.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Jogador")
@NamedQueries({ 
	@NamedQuery(name = "Jogador.getLogin", 
			query = "SELECT j FROM Jogador j WHERE j.nickname = :nickname AND j.senha = :senha"),
	@NamedQuery(name = "Jogador.getUser", 
	query = "SELECT j FROM Jogador j WHERE j.nickname = :nickname")
	})
//select p.*
//from mariokart.personagem as p 
//join mariokart.jogador as j
//where p.id = j.idPersonagem and j.id = 1

//SELECT E FROM mariokart.jogador WHERE jogador.nickname = e.getNickname AND jogador.senha = w.getSenha
public class Jogador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nickname;
	private String senha;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idPersonagem")
	private Personagem personagem;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

}
