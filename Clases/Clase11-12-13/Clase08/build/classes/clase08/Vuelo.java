package clase08;

public class Vuelo {
    private String vuelo;
    private int cantidadPasajes;

    public Vuelo(String vuelo, int cantidadPasajes) {
        this.vuelo = vuelo;
        this.cantidadPasajes = cantidadPasajes;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "vuelo=" + vuelo + ", cantidadPasajes=" + cantidadPasajes + '}';
    }
    
    public synchronized void venderPasajes(int cantidad)throws NoHayMasPasajesException{
        if(cantidad>cantidadPasajes) 
            throw new NoHayMasPasajesException(vuelo,cantidad);
        cantidadPasajes-=cantidad;
    }
    
    public boolean venderPasajes2(int cantidad){
        if(cantidad>cantidadPasajes) return false;
        cantidadPasajes-=cantidad;
        return true;

    }
}
