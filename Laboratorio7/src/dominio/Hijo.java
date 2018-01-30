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
public class Hijo extends Persona{
    
    private int lugarDeEstudio;
    
    public static final int JARDIN = 1;
    public static final int PRIMARIA = 2;
    public static final int SECUNDARIA = 3;

    public Hijo(String nombre, String apellido, boolean esMasculino, int lugarDeEstudio) {
        super(nombre, apellido, esMasculino, 0);
        this.lugarDeEstudio = lugarDeEstudio;
    }

    public int getLugarDeEstudio() {
        return lugarDeEstudio;
    }

    public void setLugarDeEstudio(int lugarDeEstudio) {
        this.lugarDeEstudio = lugarDeEstudio;
    }

    @Override
    public String toString() {
        String texto = super.toString() + "\nLugar De Estudio: ";
        switch(lugarDeEstudio){
            case 1: texto+="Jardin";break;
            case 2: texto+="Primaria";break;
            case 3: texto+="Secundaria";break;
            default:break;
        }
        return texto;
    }

    
    
    
}
