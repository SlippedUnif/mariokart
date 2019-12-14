package com.stefanini.hackaton.entities;

import com.stefanini.hackaton.dto.PersonagemDto;

public class Concorrente {
	private String nickname;
	private PersonagemDto personagemdto;
	private Double notaCorrida;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public PersonagemDto getPersonagemdto() {
		return personagemdto;
	}
	public void setPersonagemdto(PersonagemDto personagemdto) {
		this.personagemdto = personagemdto;
	}
	public Double getNotaCorrida() {
		return notaCorrida;
	}
	public void setNotaCorrida(Double notaCorrida) {
		this.notaCorrida = notaCorrida;
	}
	
	
}
