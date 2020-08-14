package ar.com.eduit.curso.java.util;

import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validator {
    private JTextField swText=null;
    private TextField fxText=null;

    public Validator(JTextField swText) {
        this.swText = swText;
    }

    public Validator(TextField fxText) {
        this.fxText = fxText;
    }
    
    private String getText(){
        if(swText!=null) return swText.getText();
        if(fxText!=null) return fxText.getText();
        return null;
    }
    
    private void requestFocus(){
        if(swText!=null) swText.requestFocus();
        if(fxText!=null) fxText.requestFocus();
    }
    
    public boolean length(int size){
        int length=getText().length();
        if(length==size) return true;
        JOptionPane.showMessageDialog(null
                , "La longitud de texto debe tener "+size+" letras.");
        requestFocus();
        return false;
    }
    
    public boolean length(int min,int max){
        int length=getText().length();
        if(length>=min && length<=max) return true;
        JOptionPane.showMessageDialog(null
                , "La longitud de texto debe ser entre "+min
                        +" y "+max+" letras.");
        requestFocus();
        return false;
    }
    
    public boolean isInteger(){
        try {
            Integer.parseInt(getText());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ser un número entero.");
            requestFocus();
            return false;
        }
    }
    
    public boolean isInteger(int min,int max){
        try {
            int num=Integer.parseInt(getText());
            if(num>=min && num<=max) return true;
            else {
                JOptionPane.showMessageDialog(null, "Debe ser un número entero entre "
                +min+" y "+max);
                requestFocus();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ser un número entero entre "
                +min+" y "+max);
            requestFocus();
            return false;
        }
    }
}
