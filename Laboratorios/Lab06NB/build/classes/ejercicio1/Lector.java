package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Facundo
 */
public class Lector {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader in = new FileReader(new File("txts/fuente.txt"));
        int caracter;
        while((caracter = in.read())!=-1)
            System.out.print((char)caracter);
        in.close();        
    }
    
}
