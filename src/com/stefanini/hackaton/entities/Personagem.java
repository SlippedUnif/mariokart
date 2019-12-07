package com.stefanini.hackaton.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Personagem")
@NamedQueries({ @NamedQuery(name = "Personagem.getAll", query = "SELECT p FROM Personagem p") })
public class Personagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	@Id
	private String nome;
	private Integer velocidade;
	private Integer aceleracao;
	private Integer peso;
	private Integer manobra;
	private Integer tracao;
	private Integer turbo;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}

	public Integer getAceleracao() {
		return aceleracao;
	}

	public void setAceleracao(Integer aceleracao) {
		this.aceleracao = aceleracao;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getManobra() {
		return manobra;
	}

	public void setManobra(Integer manobra) {
		this.manobra = manobra;
	}

	public Integer getTracao() {
		return tracao;
	}

	public void setTracao(Integer tracao) {
		this.tracao = tracao;
	}

	public Integer getTurbo() {
		return turbo;
	}

	public void setTurbo(Integer turbo) {
		this.turbo = turbo;
	}

}
