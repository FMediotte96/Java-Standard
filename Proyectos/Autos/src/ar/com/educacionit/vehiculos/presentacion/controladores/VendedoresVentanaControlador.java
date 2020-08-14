/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import ar.com.educacionit.vehiculos.entidades.Vendedor;
import ar.com.educacionit.vehiculos.presentacion.ventanas.Ventanas;
import ar.com.educacionit.vehiculos.util.AdministradorDeConexiones;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class VendedoresVentanaControlador extends ConcesionariaControlador implements Initializable {

    @FXML
    private Button btnCerrar;
    @FXML
    private Label lbl_nombre;
    @FXML
    private Label lbl_apellido;
    @FXML
    private Label lbl_dni;
    @FXML
    private Label lbl_autosVendidos;
    @FXML
    private Button btn_editar;
    @FXML
    private Button btn_borrar;
    @FXML
    private TableView<Vendedor> table_vendedor;
    @FXML
    private TableColumn<Vendedor, String> column_nombre;
    @FXML
    private TableColumn<Vendedor, String> column_apellido;
    
    private ObservableList<Vendedor> vendedorData = FXCollections.observableArrayList();
    
    private Connection conn;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Inicializo la tabla con dos columnas
        column_nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        column_apellido.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
        
        try {
            conn = AdministradorDeConexiones.getConnection();
            llenarListaVendedores();
        } catch (Exception ex) {
            System.out.println("Fallo la conexión con la base de datos");
        }
        //Listener para detectar el cambio de seleccion
        table_vendedor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> cargarVendedorSeleccionado(newValue));
        
        table_vendedor.setItems(vendedorData);
    }    

    @FXML
    private void nuevo(ActionEvent event) throws Exception {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        Vendedor nuevoVendedor = new Vendedor();
        super.mainApp.mostrarVentanaModal(Ventanas.VendedoresEdicion, stage, nuevoVendedor);
        if(!nuevoVendedor.getNombre().equals("") && !nuevoVendedor.getApellido().equals("") &&
                !nuevoVendedor.getNumeroDocumento().equals("")) {
            vendedorData.add(nuevoVendedor);
            nuevoVendedor.setId(nuevoVendedor.insertar(conn));
            table_vendedor.getSelectionModel().select(nuevoVendedor);
        }
        
    }

    @FXML
    private void editar(ActionEvent event) throws Exception {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        super.mainApp.mostrarVentanaModal(Ventanas.VendedoresEdicion, stage, 
                table_vendedor.getSelectionModel().getSelectedItem());
        table_vendedor.getSelectionModel().getSelectedItem().actualizar(conn);
        cargarVendedorSeleccionado(table_vendedor.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void borrar(ActionEvent event) throws Exception {
        int selectedIndex = table_vendedor.getSelectionModel().getSelectedIndex();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Vendedor");
        alert.setHeaderText(null);
        alert.setContentText("Desea eliminar el vendedor?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
            vendedorData.get(selectedIndex).eliminar(conn);
            table_vendedor.getItems().remove(selectedIndex);
        }
        
    }

    @FXML
    private void cerrar(ActionEvent event) throws SQLException {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        conn.close();
        stage.close();
    }

    private void cargarVendedorSeleccionado(Vendedor v) {
        if(v!=null) {
            this.lbl_nombre.setText(v.getNombre());
            this.lbl_apellido.setText(v.getApellido());
            this.lbl_dni.setText(v.getNumeroDocumento());
            this.lbl_autosVendidos.setText(String.valueOf(v.getCantAutosVendidos()));
            btn_editar.setDisable(false);
            btn_borrar.setDisable(false);
        }else {
            this.lbl_nombre.setText("");
            this.lbl_apellido.setText("");
            this.lbl_dni.setText("");
            this.lbl_autosVendidos.setText("");
            btn_editar.setDisable(true);
            btn_borrar.setDisable(true);
        }
    }

    private void llenarListaVendedores() throws Exception {

        ArrayList<Vendedor> vendedores = Vendedor.obtenerTodos(conn);
        
        vendedores.forEach(vendedor -> {
            vendedorData.add(vendedor);
        });
    }
    
}
