package domain;

public class Persona {
	
	private int dni;
	private String fullname;
	
	public Persona() {
	}

	public Persona(int dni, String fullname) {
		this.dni = dni;
		this.fullname = fullname;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	@Override
	public String toString() {
		return "Persona[" + this.getDni() + "-" + this.getFullname() + "]";
	}
	
}
