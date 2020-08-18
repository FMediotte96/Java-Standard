package ar.com.educacionit.curso.java.test;

import ar.com.educacionit.curso.java.util.MArchivo;

public class TestArchivo {
    public static void main(String[] args){
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
        
        //StringBuffer  -> contiene un string en un único objeto.
        //              -> es obsoleta
        //              -> jdk 1
        
        //StringBuilder -> jdk 5
        System.out.println("--------------------------------");
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
        archivo.append("Privamera.\n");
        archivo.append("Verano.\n");
        archivo.append("Otoño.\n");
        archivo.append("Invierno.\n");
        System.out.println(archivo.getText());
        System.out.println("--------------------");
        archivo.open();
        String linea=null;
        while((linea=archivo.getLine())!=null){
            System.out.println(linea);
        }
        archivo.close();
        System.out.println("---------------------");
        archivo.addLine("Soleado");
        archivo.getLines().forEach(System.out::println);
    }
}
