package ejercicio5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Facundo
 */
public class EscritorMejorado {
    
    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("txts/destino3.txt")));
        String cadena = "Hola, soy la línea #1";
        out.write(cadena);
        out.newLine();
        cadena = "Como te va? Yo soy la línea #2!";
        out.write(cadena);
        out.newLine();
        cadena = "Y yo la línea #3!!!";
        out.write(cadena);
        out.newLine();
        out.close();
    }
    
}
