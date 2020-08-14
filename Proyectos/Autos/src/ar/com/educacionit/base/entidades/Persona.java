package ar.com.educacionit.base.entidades;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Persona {
    
    protected StringProperty nombre;
    protected StringProperty apellido;
    protected String numeroDocumento;

    public Persona(String nombre, String apellido, String numeroDocumento) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", DNI: " + numeroDocumento;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty apellidoProperty() {
        return apellido;
    }    
  
}
