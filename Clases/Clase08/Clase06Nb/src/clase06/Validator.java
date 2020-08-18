package clase06;

import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validator {
    private JTextField swText = null;
    private TextField fxText = null;

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
    
    public boolean length(int min,int max){
        int length = getText().length();
        if(length>=min && length<=max) return true;
        JOptionPane.showMessageDialog(null
                , "La longitud de texto debe ser entre "+min+" y "+max+" letras.");
        requestFocus();
        return false;
    }
    
    
}
