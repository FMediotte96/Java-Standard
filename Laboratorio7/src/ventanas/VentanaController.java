/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import dominio.Cliente;
import dominio.Hijo;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Facundo
 */
public class VentanaController implements Initializable {
    
    @FXML
    private TextField fld_nombre;
    @FXML
    private TextField fld_apellido;
    @FXML
    private ComboBox<String> cmb_sexo;
    @FXML
    private ComboBox<String> cmb_estadoCivil;
    @FXML
    private CheckBox chk_tarjeta;
    @FXML
    private CheckBox chk_debito;
    @FXML
    private CheckBox chk_transferencia;
    @FXML
    private ComboBox<String> cmb_jardin;
    @FXML
    private ComboBox<String> cmb_primaria;
    @FXML
    private ComboBox<String> cmb_secundaria;
    @FXML
    private TextArea txa_datos;
    @FXML
    private Button btn_guardar;
    
    Cliente cliente;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cliente = new Cliente("Facundo", "Mediotte", true, Cliente.CASADO);
        ArrayList<Hijo> hijos = new ArrayList<>();
        hijos.add(new Hijo("Gonzalo", cliente.getApellido(), true, Hijo.JARDIN));
        hijos.add(new Hijo("Joaquin", cliente.getApellido(), true, Hijo.PRIMARIA));
        hijos.add(new Hijo("Zoe", cliente.getApellido(), false, Hijo.PRIMARIA));
        hijos.add(new Hijo("Camila", cliente.getApellido(),false, Hijo.SECUNDARIA));
        hijos.add(new Hijo("Martín", cliente.getApellido(),true, Hijo.SECUNDARIA));
        cliente.setHijos(hijos);
        
        cliente.setFormaDePagoDebitoAutomatico(true);
        cliente.setFormaDePagoTarjetaCredito(true);
        cliente.setFormaDePagoTransferenciaBancaria(false);
        
        cmb_sexo.getItems().add("Masculino");
        cmb_sexo.getItems().add("Femenino");
        
        cmb_estadoCivil.getItems().add(0,"Soltero");
        cmb_estadoCivil.getItems().add(1,"Casado");
        cmb_estadoCivil.getItems().add(2,"Divorciado");
        
        fld_nombre.setText(cliente.getNombre());
        fld_apellido.setText(cliente.getApellido());
        cmb_sexo.setValue((cliente.isEsMasculino())?"Masculino":"Femenino");
        cmb_estadoCivil.getSelectionModel().select(cliente.getEstadoCivil() -1);
        chk_tarjeta.setSelected(cliente.isFormaDePagoTarjetaCredito());
        chk_debito.setSelected(cliente.isFormaDePagoDebitoAutomatico());
        chk_transferencia.setSelected(cliente.isFormaDePagoTransferenciaBancaria());
        cmb_jardin.getItems().add("");
        cmb_primaria.getItems().add("");
        cmb_secundaria.getItems().add("");
        
        cliente.getHijos().forEach(hijo->{
            
            switch(hijo.getLugarDeEstudio()){ 
                case Hijo.JARDIN: 
                    cmb_jardin.getItems().add(hijo.getNombre());
                    break;
                case Hijo.PRIMARIA:
                    cmb_primaria.getItems().add(hijo.getNombre());
                    break;
                case Hijo.SECUNDARIA:
                    cmb_secundaria.getItems().add(hijo.getNombre());
                    break;
            }
        });
        
    }    

    @FXML
    private void promover1(ActionEvent event) {
        String hijo = cmb_jardin.getValue();
        if(hijo!=null){
            cmb_jardin.getItems().remove(hijo);
            cmb_primaria.getItems().add(hijo);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Ningun hijo/a seleccionado");
            alert.showAndWait();
        }
        
    }

    @FXML
    private void promover2(ActionEvent event) {
        String hijo = cmb_primaria.getValue();
        if(hijo!=null){
            cmb_primaria.getItems().remove(hijo);
            cmb_secundaria.getItems().add(hijo);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Ningun hijo/a seleccionado");
            alert.showAndWait();
        }
    }

    @FXML
    private void guardar(ActionEvent event) {
        JOptionPane.showConfirmDialog(null, "Confirma actualización de datos?",
                "Guardar cambios", JOptionPane.YES_NO_OPTION);           
        
    }

    @FXML
    private void seleccionar1(ActionEvent event) {
        String nombre = cmb_jardin.getValue();
        cliente.getHijos().forEach(hijo->{
            if(hijo.getNombre().equals(nombre)){
                txa_datos.setText(hijo.toString());
                cmb_primaria.setValue("");
                cmb_secundaria.setValue("");
            }
        });
        
    }
    
    @FXML
    private void seleccionar2(ActionEvent event) {
        String nombre = cmb_primaria.getValue();
        cliente.getHijos().forEach(hijo->{
            if(hijo.getNombre().equals(nombre)){
                txa_datos.setText(hijo.toString());
                cmb_jardin.setValue("");
                cmb_secundaria.setValue("");
            }
        });
    }

    @FXML
    private void seleccionar3(ActionEvent event) {
        String nombre = cmb_secundaria.getValue();
        cliente.getHijos().forEach(hijo->{
            if(hijo.getNombre().equals(nombre)){
                txa_datos.setText(hijo.toString());
                cmb_jardin.setValue("");
                cmb_primaria.setValue("");
            }
        });
    }
    
}
