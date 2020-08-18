/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Facundo
 */
public class CopiadorVisualController implements Initializable {
    
    @FXML
    private Button btnOrigen;
    @FXML
    private Button btnDestino;
    @FXML
    private TextField fld_origen;
    @FXML
    private TextField fld_destino;
    @FXML
    private Button btnCopiar;
    
    private BufferedReader in;
    private BufferedWriter out;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fld_origen.setEditable(false);
        fld_destino.setEditable(false);
    }    

    @FXML
    private void origen(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccione el archivo de origen");
        File file = fc.showOpenDialog(btnOrigen.getScene().getWindow());
        if(file!=null){
            fld_origen.setText(file.getAbsolutePath());
            try {
                in = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Archivo inexistente.");
            }
        }
    }

    @FXML
    private void destino(ActionEvent event) {
        FileChooser dc = new FileChooser();
        dc.setTitle("Seleccion el archivo de destino");
        File file = dc.showOpenDialog(btnDestino.getScene().getWindow());
        if(file!=null) {
            fld_destino.setText(file.getAbsolutePath());
            try {
                out = new BufferedWriter(new FileWriter(file));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Archivo de destino no encontrado.");
            }
        }
    }

    @FXML
    private void copiar(ActionEvent event) {
        String cadenaLeida;
        if(validarCampos()){
            try {
                while((cadenaLeida = in.readLine())!=null){
                    out.write(cadenaLeida);
                    out.newLine();
                    JOptionPane.showMessageDialog(null, "El archivo ha sido copiado con éxito", 
                            "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos", 
                        "Atencion!", JOptionPane.WARNING_MESSAGE);
            } finally{
                try {
                    in.close();
                    out.close();
                    fld_origen.setText("");
                    fld_destino.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ruta de acceso perdida", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
    }
    
    public boolean validarCampos(){
        if(fld_origen.getText().isEmpty() || fld_destino.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Datos incompletos");
            alert.setContentText("Completar todos los campos");
            alert.showAndWait();
            return false;
        }
        return true;
    }
    
}
