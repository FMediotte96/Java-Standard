package com.educacionit.jse.excepciones;

public class CalculadoraException extends Exception {
	private String mensaje;
	
	public CalculadoraException(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage() {
		return mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
