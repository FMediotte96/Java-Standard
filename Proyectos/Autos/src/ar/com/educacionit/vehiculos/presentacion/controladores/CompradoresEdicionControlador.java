/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import ar.com.educacionit.vehiculos.entidades.Comprador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/**
 *
 * @author Facundo
 */
public class CompradoresEdicionControlador extends EdicionControlador {
    
    @FXML
    private TextField txf_nombre;
    @FXML
    private TextField txf_apellido;
    @FXML
    private TextField txf_dni;
    @FXML
    private TextField txf_presupuesto;
    @FXML
    private Button btn_OK;
    @FXML
    private Button btn_cancelar;
    
    private Comprador comprador;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txf_nombre.requestFocus();
        
        txf_nombre.setTooltip(new Tooltip("nombre"));
        txf_apellido.setTooltip(new Tooltip("apellido"));
        txf_dni.setTooltip(new Tooltip("nro. de documento"));
        txf_presupuesto.setTooltip(new Tooltip("presupuesto"));
        
        campos.add(txf_nombre);
        campos.add(txf_apellido);
        campos.add(txf_dni);
        campos.add(txf_presupuesto);
        
    }    

    @FXML
    private void confirmar(ActionEvent event) {
        boolean ok = validarCampos();
        if (ok && validar()) {
            if(validacionOk()){
                this.comprador.setNombre(txf_nombre.getText());
                this.comprador.setApellido(txf_apellido.getText());
                this.comprador.setNumeroDocumento(txf_dni.getText());
                this.comprador.setPresupuesto(Double.parseDouble(txf_presupuesto.getText()));
                cancelar(event);
            }
        } 
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stage = (Stage) btn_cancelar.getScene().getWindow();
        stage.close();
    }
    
    private boolean validar() {
        if(!isDouble(txf_presupuesto))return false;
        return true;
    }

    @Override
    public void setearEntidad(Object entidad) {

        Comprador c = (Comprador) entidad;
        this.comprador = c;
        txf_nombre.setText(c.getNombre());
        txf_apellido.setText(c.getApellido());
        txf_dni.setText(c.getNumeroDocumento());
        txf_presupuesto.setText(String.valueOf(c.getPresupuesto()));
        
    }
    
}
