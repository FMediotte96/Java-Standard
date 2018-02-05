/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import ar.com.educacionit.vehiculos.entidades.Vendedor;
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
public class VendedoresEdicionControlador extends EdicionControlador {
    
    @FXML
    private TextField txf_nombre;
    @FXML
    private TextField txf_apellido;
    @FXML
    private TextField txf_dni;
    @FXML
    private TextField txf_autosVendidos;
    @FXML
    private Button btn_OK;
    @FXML
    private Button btn_cancelar;
    
    private Vendedor vendedor;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txf_nombre.requestFocus();
        
        txf_nombre.setTooltip(new Tooltip("nombre"));
        txf_apellido.setTooltip(new Tooltip("apellido"));
        txf_dni.setTooltip(new Tooltip("dni"));
        txf_autosVendidos.setTooltip(new Tooltip("autos vendidos"));
        
        campos.add(txf_nombre);
        campos.add(txf_apellido);
        campos.add(txf_dni);
        campos.add(txf_autosVendidos);
        
    }    

    @FXML
    private void confirmar(ActionEvent event) {
        boolean ok = validarCampos();
        if(ok && validar()){
            if(validacionOk()) {
                this.vendedor.setNombre(txf_nombre.getText());
                this.vendedor.setApellido(txf_apellido.getText());
                this.vendedor.setNumeroDocumento(txf_dni.getText());
                this.vendedor.setCantAutosVendidos(Integer.parseInt(txf_autosVendidos.getText()));
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
        if(!isInteger(txf_autosVendidos))return false;
        return true;
    }

    @Override
    public void setearEntidad(Object entidad) {
        Vendedor v = (Vendedor) entidad;
        this.vendedor = v;
        txf_nombre.setText(v.getNombre());
        txf_apellido.setText(v.getApellido());
        txf_dni.setText(v.getNumeroDocumento());
        txf_autosVendidos.setText(String.valueOf(v.getCantAutosVendidos()));
    }
    
}
