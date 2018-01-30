
package ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Facundo
 */
public class Copiador {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        FileReader in = new FileReader(new File("txts/fuente.txt"));
        FileWriter out = new FileWriter(new File("txts/destino2.txt"));
        int caracter;
        while((caracter = in.read())!=-1){
            out.write(caracter);
        }
        in.close();
        out.close();
    }
    
}
