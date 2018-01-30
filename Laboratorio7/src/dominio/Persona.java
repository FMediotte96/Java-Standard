/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Facundo
 */
public abstract class Persona {
    private String nombre;
    private String apellido;
    private boolean esMasculino;
    private int estadoCivil;

    public Persona(String nombre, String apellido, boolean esMasculino, int estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.esMasculino = esMasculino;
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEsMasculino() {
        return esMasculino;
    }

    public void setEsMasculino(boolean esMasculino) {
        this.esMasculino = esMasculino;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        String texto = "Nombre " + nombre;
        texto+="\nApellido: " + apellido;
        texto+="\nGenero: ";
        if(esMasculino){
            texto+="Masculino";
        }else
            texto+="Femenino";
        return texto;
    }
   
}
