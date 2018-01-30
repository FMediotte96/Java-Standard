package ar.com.educacionit.base.entidades;

public abstract class Persona {
    
    protected String nombre;
    protected String apellido;
    protected String numeroDocumento;

    public Persona(String nombre, String apellido, String numeroDocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", DNI: " + numeroDocumento;
    }
  
}
