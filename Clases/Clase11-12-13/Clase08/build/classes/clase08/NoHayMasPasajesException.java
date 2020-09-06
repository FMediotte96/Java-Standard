package clase08;

public class NoHayMasPasajesException extends Exception{
    private String vuelo;
    private int cantidad;

    public NoHayMasPasajesException(String vuelo, int cantidad) {
        this.vuelo = vuelo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "El vuelo "+ vuelo + ", no tiene " + cantidad + " pasajes.";
    }

    public String getVuelo() {
        return vuelo;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
    
}
