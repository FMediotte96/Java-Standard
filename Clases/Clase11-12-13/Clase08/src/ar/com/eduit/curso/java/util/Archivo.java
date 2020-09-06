package ar.com.eduit.curso.java.util;

import java.util.List;

public interface Archivo {
    void print();
    String getText();
    void setText(String text);
    void append(String text);
    List<String> getLines();
    void addLine(String line);
    void removeLine(String line);
}
