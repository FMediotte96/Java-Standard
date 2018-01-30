/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import ar.com.eduit.curso.java.util.MArchivo;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author educacionit
 */
public class FXMLDocumentController implements Initializable {

    private MArchivo archivo;
    
    @FXML
    private TextArea txaTexto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevo(ActionEvent event) {
        if(JOptionPane.showConfirmDialog(null,"Se borrara el texto anterior.")==0)
            txaTexto.setText("");
    }

    @FXML
    private void abrir(ActionEvent event) {
        FileChooser fc=new FileChooser();
        File file=fc.showOpenDialog(null);
        if(file!=null){
            archivo=new MArchivo(file);
            txaTexto.setText(archivo.getText());
        }
    }

    @FXML
    private void guardar(ActionEvent event) {
        FileChooser fc=new FileChooser();
        File file=fc.showSaveDialog(null);
        if(file!=null){
            archivo=new MArchivo(file);
            archivo.setText(txaTexto.getText());
        }
        
    }

    @FXML
    private void acerca(ActionEvent event) {
        JOptionPane.showMessageDialog(null,"Notepad.\nCurso Java Septiembre 2017.");
    }

    @FXML
    private void cerrar(ActionEvent event) {
        System.exit(0);
    }
    
}
