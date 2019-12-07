package com.stefanini.hackaton.rest.config;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.stefanini.hackaton.rest.exceptions.NegocioException;

@Provider
public class ErrorFilter implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception ex) {
		Status status = null;
		final StringWriter sw = new StringWriter();
		
		if (ex instanceof NegocioException) {
			status = Status.BAD_REQUEST;
		
		} else {
			status = Status.INTERNAL_SERVER_ERROR;
			ex.printStackTrace(new PrintWriter(sw));
			ex.printStackTrace();
		}
		
		MensagemErro msg = new MensagemErro();
		msg.setMensagem(ex.getMessage());
		msg.setStatusCode(status.getStatusCode());
		msg.setStack(sw.toString());
		
		return Response.ok(msg)
				.type(MediaType.APPLICATION_JSON)
				.status(status.getStatusCode()).build();
	}

	
	
	
	
	
	
}
