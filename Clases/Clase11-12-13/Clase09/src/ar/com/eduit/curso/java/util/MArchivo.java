package ar.com.eduit.curso.java.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MArchivo implements Archivo{
    private File file;

    public MArchivo(File file) {
        this.file = file;
    }
    
    public MArchivo(String file){
        this.file= new File(file);
    }
    
    @Override
    public void print() {
        int car;
        try {
            FileReader in=new FileReader(file);
            while((car=in.read())!=-1){
                System.out.print((char)car);
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    @Override
    public String getText() {
        StringBuilder sb=new StringBuilder();           //
        int car;
        try {
            FileReader in=new FileReader(file);
            while((car=in.read())!=-1){
                sb.append((char)car);                   //
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return sb.toString();                           //
    }

    @Override
    public void setText(String text) {
        try {
           FileWriter out=new FileWriter(file); 
           out.write(text);
           out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void append(String text) {
      try {
           FileWriter out=new FileWriter(file,true);    // 
           out.write(text);
           out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private BufferedReader in;
    public void open(){
        try{
            in=new BufferedReader(new FileReader(file));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void close(){
        try {
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String getLine(){
        String line=null;
        try {
            line=in.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        return line;
    }
    
    @Override
    public List<String> getLines() {
        List<String> lista=new ArrayList();
        String line;
        open();
        while((line=getLine())!=null){
            lista.add(line);
        }
        close();
        return lista;
    }

    @Override
    public void addLine(String line) {
        //append(line+"\n");
        try {
            BufferedWriter out=new BufferedWriter(new FileWriter(file,true));
            out.write(line);
            out.newLine();
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeLine(String line) {
        List<String>lista=getLines();
        lista.remove(line);
        setText("");
        lista.forEach(item->addLine(item));
    }
    
}
