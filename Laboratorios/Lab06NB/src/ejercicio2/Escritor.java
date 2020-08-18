package ejercicio2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Facundo
 */
public class Escritor {
    
    public static void main(String[] args) throws IOException {
        FileWriter out = new FileWriter(new File("txts/destino.txt"));
        String cadena = "Soy la información.";
        for(int i=0;i<cadena.length();i++){
            out.write(cadena.charAt(i));
        }
        out.close();
    }
}
