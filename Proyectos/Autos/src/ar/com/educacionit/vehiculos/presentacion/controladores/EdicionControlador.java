/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Facundo
 */
public abstract class EdicionControlador implements Initializable{
    
    protected List<Control> campos;

    public EdicionControlador() {
        this.campos = new ArrayList<>();
    }
    
    public abstract void setearEntidad(Object entidad);
    
    public boolean validarCampos() {
        for(Control campo : campos){
            if(campo instanceof TextField){
                TextField c = (TextField) campo;
                if(c.getText().isEmpty() || c.getText().equals("0.0") || (c.getText().equals("0"))){
                    validacionFalla(campo);
                    return false;
                }
            }
            if(campo instanceof TextArea){
                TextArea c = (TextArea) campo;
                if(c.getText().isEmpty()){
                    validacionFalla(campo);
                    return false;
                }
            }
            if(campo instanceof ComboBox) {
                ComboBox<String> c = (ComboBox) campo;
                if(c.getValue() == null){
                    validacionFalla(campo);
                    return false;
                }
            }
        }
        return true;
    }

    public void validacionFalla(Control control) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Datos incompletos");
        alert.setHeaderText("Por favor complete todos los campos");
        alert.setContentText("El campo " + control.getTooltip().getText() + " no puede estar vacio");
        alert.showAndWait();
        control.requestFocus();
    }

    public boolean validacionOk() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion");
        alert.setHeaderText(null);
        alert.setContentText("Está a punto de guardar los datos, desea continuar?");
        
        
        Optional<ButtonType> result = alert.showAndWait();
        return(result.get() == ButtonType.OK);
    }
    
    public boolean isDouble(TextField control) {
        try {
            Double.parseDouble(control.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo " + control.getTooltip().getText() 
                        + " debe ser un numero con decimales.");
            control.requestFocus();
            return false;
        }
    }
    
    public boolean isInteger(TextField control) {
        try {
            Integer.parseInt(control.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo " + control.getTooltip().getText()
                        + " debe ser un numero entero.");
            control.requestFocus();
            return false;
        }
    }
}
