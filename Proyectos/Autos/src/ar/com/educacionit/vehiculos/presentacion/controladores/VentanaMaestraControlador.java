/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import ar.com.educacionit.vehiculos.aplicacion.APPConcesionaria;
import ar.com.educacionit.vehiculos.presentacion.ventanas.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Facundo
 */
public class VentanaMaestraControlador extends ConcesionariaControlador implements Initializable {
    
    @FXML
    private MenuItem itemConfiguracion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showVentanaAutos(ActionEvent event) {
        super.mainApp.showInternalWindow(Ventanas.AutosVentana);
    }

    @FXML
    private void showVentanaVendedores(ActionEvent event) {
        super.mainApp.showInternalWindow(Ventanas.VendedoresVentana);
    }

    @FXML
    private void showVentanaCompradores(ActionEvent event) {
        super.mainApp.showInternalWindow(Ventanas.CompradoresVentana);
    }
    
    @FXML
    private void showVentanaConfiguracion(ActionEvent event) {
        super.mainApp.showInternalWindow(Ventanas.VentanaConfiguracion);
    }
    
    @FXML
    private void salir(ActionEvent event) {
        Platform.exit();
    }

    
        
}
