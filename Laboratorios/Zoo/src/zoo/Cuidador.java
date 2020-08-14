package zoo;

public class Cuidador extends Persona{

    private int cantidadDeRaciones;

    public Cuidador(int cantidadDeRaciones) {        
        this.cantidadDeRaciones = cantidadDeRaciones;
    }
     
    public void alimentarAnimales(){
        if(cantidadDeRaciones >= 
                Zoologico.CANTIDAD_DE_ANIMALES * Zoologico.RACIONES_POR_ANIMAL){
            System.out.println("Las raciones alcanzaron para alimentar a todos los animales.");
        }else
            System.out.println("Las raciones que se le entregaron al cuidador fueron insuficientes.");
    }
}
