/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import ar.com.educacionit.vehiculos.presentacion.ventanas.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author Facundo
 */
public class AutosVentanaControlador extends ConcesionariaControlador implements Initializable {

    @FXML
    private Button btn_cerrar;
    @FXML
    private TextArea txa_equipamiento;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txa_equipamiento.setEditable(false);
    }    

    @FXML
    private void nuevo(ActionEvent event) {
        Stage stage = (Stage) btn_cerrar.getScene().getWindow();
        super.mainApp.mostrarVentanaModal(Ventanas.AutosEdicion, stage);
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void borrar(ActionEvent event) {
    }

    @FXML
    private void cerrar(ActionEvent event) {
        Stage stage = (Stage) btn_cerrar.getScene().getWindow();
        stage.close();
    }
    
}
