package clase04;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;


public class FXMLDocumentController implements Initializable {
    
    private ToggleGroup grupo;
    
    @FXML //VISTA
    TextField txtNombre;
    @FXML
    private CheckBox chkBici;
    @FXML
    private CheckBox chkAuto;
    @FXML
    private CheckBox chkMoto;
    @FXML
    private TextArea txaTexto;
    @FXML
    private RadioButton radSoltero;
    @FXML
    private RadioButton radCasado;
    @FXML
    private RadioButton radViudo;
    @FXML
    private RadioButton radDivorciado;
    @FXML
    private ComboBox<String> cmbColores; //Generics
    
    
    @FXML
    public void aceptar(ActionEvent evt){
        JOptionPane.showMessageDialog(null, "Hola "+txtNombre.getText());
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        grupo=new ToggleGroup();
        radSoltero.setToggleGroup(grupo);
        radCasado.setToggleGroup(grupo);
        radViudo.setToggleGroup(grupo);
        radDivorciado.setToggleGroup(grupo);
        radSoltero.setSelected(true);    
        
        //carga cmbColores
        cmbColores.getItems().add("Rojo");
        cmbColores.getItems().add("Verde");
        cmbColores.getItems().add("Azul");
        cmbColores.getItems().add("Blanco");
        cmbColores.getItems().add("Negro");
        cmbColores.getItems().add("Gris");
        cmbColores.setValue("Rojo");
    }    

    @FXML
    private void agregar(ActionEvent event) {
        String texto="";
        final String nombre = txtNombre.getText().trim();
        if(!nombre.equals("")) texto+="Nombre: "+nombre+"\n";
        if(chkBici.isSelected()) texto+="Tiene Bici.\n";
        if(chkMoto.isSelected()) texto+="Tiene Moto.\n";
        if(chkAuto.isSelected()) texto+="Tiene Auto.\n";
//        if(radSoltero.isSelected()) texto+="Es Soltero.\n";
//        if(radCasado.isSelected()) texto+="Es Casado.\n";
//        if(radViudo.isSelected()) texto+="Es Viudo.\n";
//        if(radDivorciado.isSelected()) texto+="Es Divorciado.\n";
        
        //System.out.println((RadioButton)grupo.getSelectedToggle().getText()+\n);
        texto+="Es "+((RadioButton)grupo.getSelectedToggle())
                .getText().toLowerCase()+".\n";
        
        texto+="Color: "+cmbColores.getValue()+".\n";
        
        //Clase System
        texto+=System.getProperty("os.name")+".\n";
        texto+=System.getProperty("os.version")+".\n";
        texto+=System.getProperty("os.arch")+".\n";
        texto+=System.getProperty("user.name")+".\n";
        texto+=System.getProperty("user.home")+".\n";
        texto+=System.getProperty("user.country")+".\n";
        texto+=System.getProperty("user.language")+".\n";
        texto+=System.getProperty("java.version")+".\n";
        texto+=System.getProperty("user.dir")+".\n";
        
        System.out.println(System.getProperties());
        
        Date date=new Date();
        System.out.println(date); 
        /**
         * Obsoleta
         */
        
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ldt.getHour()+":"+ldt.getMinute()+":"
        +ldt.getSecond());
        //Java advanced nos va a poner la hora actualizandola.
        
        limpiar();   
        txaTexto.setText(texto);
    }

    private void limpiar() {
        //Limpiar el Formulario!
        txtNombre.setText("");
        chkBici.setSelected(false);
        chkMoto.setSelected(false);
        chkAuto.setSelected(false);
        radSoltero.setSelected(true);
        //grupo.selectToggle(null);
        cmbColores.setValue("Rojo");
        txtNombre.requestFocus();
        
        
    }

    @FXML
    private void salir(ActionEvent event) {
        //Método exit()
        System.exit(0);
    }
    
}
