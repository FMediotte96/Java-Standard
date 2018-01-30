package colegio;

import ar.com.eduit.curso.entities.Alumno;
import ar.com.eduit.curso.java.connector.Connector;
import ar.com.eduit.curso.java.repositories.AlumnoR;
import ar.com.eduit.curso.java.util.Validator;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
  
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtCurso;
    @FXML
    private Label lblInfo;
    
    private Label label;
    private Connection conn;
    private AlumnoR ar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn=Connector.getConnector();
        ar=new AlumnoR(conn);
    }    

    @FXML
    private void agregar(ActionEvent event) {
        if(validar()){
            ar.save(new Alumno(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    Integer.parseInt(txtEdad.getText()),
                    Integer.parseInt(txtCurso.getText())
            ));
            lblInfo.setText("Se ingreso un alumno.");
        }else{
            lblInfo.setText("No se pudo ingresar el alumno.");
        }  
    }
    
    private void limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtCurso.setText("");
    }
    /**
     * Valida si los datos son correctos
     * @return Verdadero o falso
     */
    private boolean validar() {
        if(!new Validator(txtNombre).length(2, 20))     return false;
        if(!new Validator(txtApellido).length(2, 20))   return false;
        if(!new Validator(txtEdad).isInteger(18, 70))   return false;
        if(!new Validator(txtCurso).isInteger())        return false;
        return true;
    }
    
}
