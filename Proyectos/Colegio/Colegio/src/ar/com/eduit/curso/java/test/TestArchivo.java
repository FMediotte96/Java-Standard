package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.util.Archivo;
import ar.com.eduit.curso.java.util.MArchivo;

public class TestArchivo {
    public static void main(String[] args) {
        //String file="c:/texto.txt";
        String file="res/texto.txt";
        MArchivo archivo=new MArchivo(file);
        //archivo.print();
        System.out.println(archivo.getText());
        
        String texto="";
        System.out.println(texto+"\t"+texto.hashCode());
        texto+="h";
        System.out.println(texto+"\t"+texto.hashCode());
        texto+="o";
        System.out.println(texto+"\t"+texto.hashCode());
        texto+="l";
        System.out.println(texto+"\t"+texto.hashCode());
        texto+="a";
        System.out.println(texto+"\t"+texto.hashCode());
        
        //StringBuffer (Obsoleta)   jdk1
        //StringBuilder             jdk5
        
        StringBuilder sb=new StringBuilder();
        System.out.println(sb.toString()+"\t"+sb.hashCode());
        sb.append("h");
        System.out.println(sb.toString()+"\t"+sb.hashCode());
        sb.append("o");
        System.out.println(sb.toString()+"\t"+sb.hashCode());
        sb.append("l");
        System.out.println(sb.toString()+"\t"+sb.hashCode());
        sb.append("a");
        System.out.println(sb.toString()+"\t"+sb.hashCode());
        
        archivo.setText("Curso de Java.\n");
        archivo.append("Primavera.\n");
        archivo.append("Verano.\n");
        archivo.append("Otoño.\n");
        archivo.append("Invierno.\n");
        System.out.println(archivo.getText());
        System.out.println("----------------");
        archivo.open();
        String linea=null;
        while((linea=archivo.getLine())!=null){
            System.out.println(linea);
        }
        archivo.close();
        System.out.println("----------------");
        archivo.addLine("Día");
        archivo.addLine("Soleado");
        archivo.getLines().forEach(System.out::println);
        System.out.println("----------------");
        archivo.removeLine("Invierno.");
        archivo.getLines().forEach(System.out::println);
        
    }
}
