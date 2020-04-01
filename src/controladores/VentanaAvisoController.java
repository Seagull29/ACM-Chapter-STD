/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author selitzia
 */
public class VentanaAvisoController implements Initializable {

    @FXML
    private Button btnCerrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
           
           
       } catch (Exception e) {
         
       }
        
        
    }    

    @FXML
    private void Cerrar(ActionEvent event) throws Exception {
       
        
        ( (Node) (event.getSource()) ).getScene().getWindow().hide();
    }
    
}
