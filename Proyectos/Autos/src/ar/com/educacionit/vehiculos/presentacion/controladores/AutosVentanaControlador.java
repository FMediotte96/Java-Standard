/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import ar.com.educacionit.vehiculos.entidades.Auto;
import ar.com.educacionit.vehiculos.presentacion.ventanas.Ventanas;
import ar.com.educacionit.vehiculos.util.AdministradorDeConexiones;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
    
    private ArrayList<Auto> autos;
    @FXML
    private TableView<Auto> table_view;
    @FXML
    private TableColumn<Auto, String> column_marca;
    @FXML
    private TableColumn<Auto, String> column_modelo;
    @FXML
    private Label fld_alto;
    @FXML
    private Label fld_ancho;
    @FXML
    private Label fld_largo;
    @FXML
    private Label fld_modelo;
    @FXML
    private Label fld_marca;
    @FXML
    private Label fld_color;
    @FXML
    private Label fld_precio;
    @FXML
    private Button btn_editar;
    @FXML
    private Button btn_borrar;
    
    private ObservableList<Auto> autosData = FXCollections.observableArrayList();
    
    private Connection conn;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txa_equipamiento.setEditable(false);
        
        //Inicializo la tabla con dos columnas
        column_marca.setCellValueFactory(cellData -> cellData.getValue().marcaProperty());
        column_modelo.setCellValueFactory(cellData -> cellData.getValue().modeloProperty());
        
        try {
            //Cargar autos desde la base de datos
            conn = AdministradorDeConexiones.getConnection();
            llenarListaAutos();
        } catch (Exception ex) {
            System.out.println("Fallo la conexión con la base de datos");
        }
        
        //Listener para detectar el cambio de seleccion
        table_view.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> cargarAutoSeleccionado(newValue));
        
        table_view.setItems(autosData);
    }    

    @FXML
    private void nuevo(ActionEvent event) throws Exception {
        Stage stage = (Stage) btn_cerrar.getScene().getWindow();
        Auto autoNuevo = new Auto();
        super.mainApp.mostrarVentanaModal(Ventanas.AutosEdicion, stage, autoNuevo);
        if(autoNuevo.getMarca() != null && autoNuevo.getModelo() != null) {
            autosData.add(autoNuevo);
            autoNuevo.setId(autoNuevo.insertar(conn));
            table_view.getSelectionModel().select(autoNuevo);
        }
    }

    @FXML
    private void editar(ActionEvent event) throws Exception {
        Stage stage = (Stage) btn_cerrar.getScene().getWindow();
        super.mainApp.mostrarVentanaModal(Ventanas.AutosEdicion, stage,
                table_view.getSelectionModel().getSelectedItem());
        table_view.getSelectionModel().getSelectedItem().actualizar(conn);
        cargarAutoSeleccionado(table_view.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void borrar(ActionEvent event) throws Exception {
        int selectIndex = table_view.getSelectionModel().getSelectedIndex();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Auto");
        alert.setHeaderText(null);
        alert.setContentText("Desea eliminar el auto?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
            autosData.get(selectIndex).eliminar(conn);
            table_view.getItems().remove(selectIndex);
            
        }
    }

    @FXML
    private void cerrar(ActionEvent event) throws SQLException {
        Stage stage = (Stage) btn_cerrar.getScene().getWindow();
        conn.close();
        stage.close();
       
    }

    private void cargarAutoSeleccionado(Auto a) {
        if(a!=null) {
            this.fld_alto.setText(String.valueOf(a.getAlto()));
            this.fld_largo.setText(String.valueOf(a.getLargo()));
            this.fld_ancho.setText(String.valueOf(a.getAncho()));
            this.fld_marca.setText(a.getMarca());
            this.fld_modelo.setText(a.getModelo());
            this.fld_color.setText(a.getColor());
            this.fld_precio.setText(String.valueOf(a.getPrecio()));
            this.txa_equipamiento.setText(a.getDescripcion());
            btn_editar.setDisable(false);
            btn_borrar.setDisable(false);
        }else {
            this.fld_alto.setText("");
            this.fld_largo.setText("");
            this.fld_ancho.setText("");
            this.fld_marca.setText("");
            this.fld_modelo.setText("");
            this.fld_color.setText("");
            this.fld_precio.setText("");
            this.txa_equipamiento.setText("");
            btn_editar.setDisable(true);
            btn_borrar.setDisable(true);
        }
        

    }

    private void llenarListaAutos() throws Exception {
                
        ArrayList<Auto> autos = Auto.obtenerTodos(conn);
        
        autos.forEach(auto -> {
            autosData.add(auto);
        });
    }
}
