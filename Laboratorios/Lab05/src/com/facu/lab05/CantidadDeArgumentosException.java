package com.facu.lab05;

public class CantidadDeArgumentosException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nivelDeError;
	private String mensajeError;
	
	public CantidadDeArgumentosException() {
		
	}

	public CantidadDeArgumentosException(String id, String nivelDeError, String mensajeError) {
		this.id = id;
		this.nivelDeError = nivelDeError;
		this.mensajeError = mensajeError;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNivelDeError() {
		return nivelDeError;
	}

	public void setNivelDeError(String nivelDeError) {
		this.nivelDeError = nivelDeError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
}
