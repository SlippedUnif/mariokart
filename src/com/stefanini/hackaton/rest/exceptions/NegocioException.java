package com.stefanini.hackaton.rest.exceptions;

public class NegocioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private NegocioException(final String mensagem) {
		super(mensagem);
	}
	
	private NegocioException(final Throwable t) {
		super(t);
	}
	
	private NegocioException(final String mensagem, final Throwable t) {
		super(mensagem, t);
	}
	
}
