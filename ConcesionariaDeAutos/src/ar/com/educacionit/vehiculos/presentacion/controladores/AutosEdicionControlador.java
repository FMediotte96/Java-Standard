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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.JSType;

/**
 *
 * @author Facundo
 */
public class AutosEdicionControlador extends EdicionControlador {

    @FXML
    private TextField txf_alto;
    @FXML
    private TextField txf_largo;
    @FXML
    private TextField txf_ancho;
    @FXML
    private TextField txf_precio;
    @FXML
    private ComboBox<String> cmb_marca;
    @FXML
    private ComboBox<String> cmb_modelo;
    @FXML
    private ComboBox<String> cmb_color;
    @FXML
    private TextArea txa_equip;
    @FXML
    private Button btn_OK;
    @FXML
    private Button btn_cancelar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txf_alto.requestFocus();
        txf_alto.setTooltip(new Tooltip("alto"));
        txf_largo.setTooltip(new Tooltip("largo"));
        txf_ancho.setTooltip(new Tooltip("ancho"));
        txf_precio.setTooltip(new Tooltip("precio"));
        txa_equip.setTooltip(new Tooltip("equipamiento"));
        
        campos.add(txf_alto);
        campos.add(txf_largo);
        campos.add(txf_ancho);
        campos.add(txf_precio);
        campos.add(txa_equip);
              
    }    

    @FXML
    private void confirmar(ActionEvent event) {
        boolean ok = validarCampos();
        if (ok && validar()) {
            validacionOk();
            cancelar(event);
        }        
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stage = (Stage) btn_cancelar.getScene().getWindow();
        stage.close();
    }
    
    private boolean validar() {
        if(!isDouble(txf_alto))return false;
        if(!isDouble(txf_largo))return false;
        if(!isDouble(txf_ancho))return false;
        if(!isDouble(txf_precio))return false;
        return true;
    }
    
}
