/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import ar.com.educacionit.vehiculos.entidades.Comprador;
import ar.com.educacionit.vehiculos.presentacion.ventanas.Ventanas;
import ar.com.educacionit.vehiculos.util.AdministradorDeConexiones;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author Facundo
 */
public class CompradoresVentanaControlador extends ConcesionariaControlador implements Initializable {

    @FXML
    private Button btnCerrar;   
    @FXML
    private TableView<Comprador> table_comprador;
    @FXML
    private TableColumn<Comprador, String> column_nombre;
    @FXML
    private TableColumn<Comprador, String> column_apellido;
    @FXML
    private Button btn_editar;
    @FXML
    private Button btn_borrar;  
    @FXML
    private Label lbl_nombre;
    @FXML
    private Label lbl_apellido;
    @FXML
    private Label lbl_dni;
    @FXML
    private Label lbl_presupuesto;
    
    ObservableList<Comprador> compradorData = FXCollections.observableArrayList();
    
    private Connection conn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Inicializo la tabla con dos columnas
        column_nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        column_apellido.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
        
        try {
            conn = AdministradorDeConexiones.getConnection();
            llenarListaCompradores();
        } catch (Exception ex) {
            System.out.println("Fallo la conexion con la base de datos");
        }
        
        //Listener para detectar el cambio de seleccion
        table_comprador.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> cargarCompradorSeleccionado(newValue));
        
        table_comprador.setItems(compradorData);
    }    

    @FXML
    private void nuevo(ActionEvent event) throws Exception {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        Comprador nuevoComprador = new Comprador();
        super.mainApp.mostrarVentanaModal(Ventanas.CompradoresEdicion, stage, nuevoComprador);
        if(!nuevoComprador.getNombre().equals("") &&
                !nuevoComprador.getApellido().equals("") &&
                    !nuevoComprador.getNumeroDocumento().equals("")) {
            compradorData.add(nuevoComprador);
            nuevoComprador.setId(nuevoComprador.insertar(conn));
            table_comprador.getSelectionModel().select(nuevoComprador);
        }
        
    }

    @FXML
    private void editar(ActionEvent event) throws Exception {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        super.mainApp.mostrarVentanaModal(Ventanas.CompradoresEdicion, stage,
                table_comprador.getSelectionModel().getSelectedItem());
        table_comprador.getSelectionModel().getSelectedItem().actualizar(conn);
        cargarCompradorSeleccionado(table_comprador.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void borrar(ActionEvent event) throws Exception {
        int selectedIndex = table_comprador.getSelectionModel().getSelectedIndex();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Comprador");
        alert.setHeaderText(null);
        alert.setContentText("Desea eliminar el comprador?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
            compradorData.get(selectedIndex).eliminar(conn);
            table_comprador.getItems().remove(selectedIndex);
        }
    }

    @FXML
    private void cerrar(ActionEvent event) throws SQLException {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        conn.close();
        stage.close();
    }

    private void cargarCompradorSeleccionado(Comprador c) {
        if(c!=null){
            this.lbl_nombre.setText(c.getNombre());
            this.lbl_apellido.setText(c.getApellido());
            this.lbl_dni.setText(c.getNumeroDocumento());
            this.lbl_presupuesto.setText(String.valueOf(c.getPresupuesto()));
            btn_editar.setDisable(false);
            btn_borrar.setDisable(false);
        }else {
            this.lbl_nombre.setText("");
            this.lbl_apellido.setText("");
            this.lbl_dni.setText("");
            this.lbl_presupuesto.setText("");
            btn_editar.setDisable(true);
            btn_borrar.setDisable(true);
        }
            
    }

    private void llenarListaCompradores() throws Exception {

        ArrayList<Comprador> compradores = Comprador.obtenerTodos(conn);
        
        compradores.forEach(comprador -> {
            compradorData.add(comprador);
        });
    }
    
}
