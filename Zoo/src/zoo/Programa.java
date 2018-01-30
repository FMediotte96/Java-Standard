package zoo;

/**
 *
 * @author Facundo
 */
public class Programa {

    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();
        zoo.abrir();
        zoo.alimentarAnimales(120);
        zoo.cerrar();
    }
}
