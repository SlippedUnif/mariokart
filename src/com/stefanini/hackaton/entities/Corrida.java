package com.stefanini.hackaton.entities;

import java.io.Serializable;
import java.util.List;

import org.apache.openejb.spi.Serializer;

import com.stefanini.hackaton.dto.JogadorDto;

public class Corrida implements Serializable{
	private double distancia;
	private List<Concorrente> concorrentes;
	private int numeroVoltas;
	private List<Concorrente> classificacao;
	private JogadorDto jogadorDto;
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public List<Concorrente> getConcorrentes() {
		return concorrentes;
	}
	public void setConcorrentes(List<Concorrente> concorrentes) {
		this.concorrentes = concorrentes;
	}
	public int getNumeroVoltas() {
		return numeroVoltas;
	}
	public void setNumeroVoltas(int numeroVoltas) {
		this.numeroVoltas = numeroVoltas;
	}
	public List<Concorrente> getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(List<Concorrente> classificacao) {
		this.classificacao = classificacao;
	}
	public JogadorDto getJogadorDto() {
		return jogadorDto;
	}
	public void setJogadorDto(JogadorDto jogadorDto) {
		this.jogadorDto = jogadorDto;
	}
	
	
	
	
}
