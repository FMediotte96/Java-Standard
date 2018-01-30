package ar.com.educacionit.base.entidades;

public abstract class Vehiculo {
    
    protected int alto;
    protected int ancho;
    protected int largo;

    public Vehiculo(int alto, int ancho, int largo) {
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "Alto: " + alto + ", Ancho: " + ancho + ", Largo: " + largo;
    }
  
}
