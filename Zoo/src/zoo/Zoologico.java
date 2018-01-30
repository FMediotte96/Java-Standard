package zoo;

public class Zoologico {
    
    public static final int RACIONES_POR_ANIMAL = 5;
    public static final int CANTIDAD_DE_ANIMALES = 25;
    
    private boolean abierto;
    
    public void abrir(){
        abierto = true;
    }
    
    public void alimentarAnimales(int unaCantidadDeRaciones){
        
        Cuidador cuidador = new Cuidador(unaCantidadDeRaciones);
        cuidador.alimentarAnimales();
    }
    
    public void cerrar(){
        abierto = false;
    }
    
}
