/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.GUI;

import static PAD.main.Main.controller;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author max
 */
public class GUIController implements Initializable {
    @FXML
    private Button buttonMode1;    // eerste knop
    @FXML
    private Button buttonMode2;    // tweede knop
    @FXML
    private Button buttonMode3;    // derde knop

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }    
    
    @FXML
    public void startMode1 (){
           
   buttonMode1.setOnAction(e -> controller.start());
   
            
           
   
    
    
    }
    private void start() {
    
       

}

}


