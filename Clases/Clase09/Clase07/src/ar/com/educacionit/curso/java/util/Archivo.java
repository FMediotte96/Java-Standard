package ar.com.educacionit.curso.java.util;

import java.util.List;

public interface Archivo {
    
    void print(); //Va a imprimir el texto de un archivo
    String getText();//Va a devolver el texto de un archivo
    void setText(String text);//Setea texto. Borra lo que exista.
    void append(String text);//Agrega al final
    List<String> getLines(); //Devuelve la lista de lineas
    void addLine(String line);
    void removeLine(String line);
    
}
