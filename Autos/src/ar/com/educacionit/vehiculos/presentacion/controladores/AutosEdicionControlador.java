/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import ar.com.educacionit.vehiculos.entidades.Auto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

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
    
    private Auto auto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txf_alto.requestFocus();
        txf_alto.setTooltip(new Tooltip("alto"));
        txf_largo.setTooltip(new Tooltip("largo"));
        txf_ancho.setTooltip(new Tooltip("ancho"));
        cmb_marca.setTooltip(new Tooltip("marca"));
        cmb_color.setTooltip(new Tooltip("color"));
        cmb_modelo.setTooltip(new Tooltip("modelo"));
        txf_precio.setTooltip(new Tooltip("precio"));
        txa_equip.setTooltip(new Tooltip("equipamiento"));
                
        campos.add(txf_alto);
        campos.add(txf_largo);
        campos.add(txf_ancho);
        campos.add(cmb_marca);
        campos.add(cmb_modelo);
        campos.add(cmb_color);
        campos.add(txf_precio);
        campos.add(txa_equip);
        
        try {
            cargarMarcas();
            cargarColores();
            cargarModelos();
        } catch (IOException ex) {
            Logger.getLogger(AutosEdicionControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }    

    @FXML
    private void confirmar(ActionEvent event) {
        boolean ok = validarCampos();
        if (ok && validar()) {
            if(validacionOk()) {
                this.auto.setAlto(Integer.parseInt(txf_alto.getText()));
                this.auto.setAncho(Integer.parseInt(txf_ancho.getText()));
                this.auto.setLargo(Integer.parseInt(txf_largo.getText()));
                this.auto.setMarca(cmb_marca.getSelectionModel().getSelectedItem());
                this.auto.setModelo(cmb_modelo.getSelectionModel().getSelectedItem());
                this.auto.setColor(cmb_color.getSelectionModel().getSelectedItem());
                this.auto.setPrecio(Double.parseDouble(txf_precio.getText()));
                this.auto.setDescripcion(txa_equip.getText());
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
        if(!isDouble(txf_alto))return false;
        if(!isDouble(txf_largo))return false;
        if(!isDouble(txf_ancho))return false;
        if(!isDouble(txf_precio))return false;
        return true;
    }
    
    private void cargarMarcas() throws IOException {
        
        cmb_marca.setPromptText("Seleccione...");
        
        File file = new File("src/ar/com/educacionit/vehiculos/recursos/marcas.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String cadenaLeida;
            while((cadenaLeida = in.readLine())!=null) {
                cmb_marca.getItems().add(cadenaLeida);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    private void cargarColores() throws IOException {
        
        cmb_color.setPromptText("Seleccione...");
        
        File file = new File("src/ar/com/educacionit/vehiculos/recursos/colores.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String cadenaLeida;
            while((cadenaLeida = in.readLine())!=null) {
                cmb_color.getItems().add(cadenaLeida);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
               
    }
    
    private void cargarModelos() {
        
        cmb_modelo.setPromptText("Seleccione...");
        
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for(int i = 1985; i<=year;i++) {
            cmb_modelo.getItems().add(String.valueOf(i));
        }
        
    }

    @Override
    public void setearEntidad(Object entidad) {
        Auto a = (Auto) entidad;
        this.auto = a;
        txf_alto.setText(String.valueOf(a.getAlto()));
        txf_largo.setText(String.valueOf(a.getLargo()));
        txf_ancho.setText(String.valueOf(a.getAncho()));
        cmb_marca.setValue(a.getMarca());
        cmb_modelo.setValue(a.getModelo());
        cmb_color.setValue(a.getColor());
        txf_precio.setText(String.valueOf(a.getPrecio()));
        txa_equip.setText(a.getDescripcion());
    }
}
