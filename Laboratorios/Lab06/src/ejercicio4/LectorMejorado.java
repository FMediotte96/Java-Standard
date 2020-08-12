package ejercicio4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Facundo
 */
public class LectorMejorado {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("txts/fuente.txt")));
        String cadenaLeida;
        while((cadenaLeida = in.readLine())!=null){
            System.out.println(cadenaLeida);
        }
        in.close();
    }
    
}
