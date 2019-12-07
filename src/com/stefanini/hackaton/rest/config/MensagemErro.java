package com.stefanini.hackaton.rest.config;

public class MensagemErro {

	private String mensagem;
	private Integer statusCode;
	private String stack;
	
	public String getStack() {
		return stack;
	}
	
	public void setStack(String stack) {
		this.stack = stack;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
