/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author Facundo
 */
public class VentanaConfiguracionControlador extends ConcesionariaControlador implements Initializable {

    @FXML
    private TextField txf_sistema;
    @FXML
    private TextField txf_so;
    @FXML
    private TextField txf_usuario;
    @FXML
    private TextField txf_java;
    @FXML
    private Button btn_cerrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txf_sistema.setText(System.getProperty("os.name"));
        txf_so.setText(System.getProperty("os.version"));
        txf_usuario.setText(System.getProperty("user.name"));
        txf_java.setText(System.getProperty("java.version"));
    }    

    @FXML
    private void salir(ActionEvent event) {
        Stage stage = (Stage) btn_cerrar.getScene().getWindow();
        stage.close();
    }
    
}
