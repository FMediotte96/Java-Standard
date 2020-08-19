package com.facu.compare;

import java.util.Comparator;

public class OrdenarPersonasPorId implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		return p1.getId() - p2.getId();
	}

}
