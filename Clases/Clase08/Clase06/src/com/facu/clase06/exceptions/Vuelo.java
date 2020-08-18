package com.facu.clase06.exceptions;

public class Vuelo {
	private String vuelo;
	private int cantidadPasajes;
	
	public Vuelo(String vuelo, int cantidadPasajes) {
		this.vuelo = vuelo;
		this.cantidadPasajes = cantidadPasajes;
	}

	@Override
	public String toString() {
		return "Vuelo{" +  "vuelo=" + vuelo + ", cantidadPasajes=" + cantidadPasajes + "}";
	}
	
	/**
	 * Se utiliza synchronized para bloquear el metodos sobre un objeto mientras esta siendo ejecutado.
	 * El proximo solicitante debe esperar a que se desbloquee
	 * @param cantidad
	 * @throws NoHayPasajesException
	 */
	public synchronized void venderPasajes(int cantidad) throws NoHayPasajesException {
		if(cantidad > cantidadPasajes) {
			throw new NoHayPasajesException(vuelo, cantidad);
		}
		cantidadPasajes -= cantidad;
	}
}
