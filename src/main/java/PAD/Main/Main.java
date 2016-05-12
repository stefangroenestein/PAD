/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main;

import PAD.GUI.InterfaceHandler;
import PAD.GUI.InterfaceName;
import PAD.game.GameHandler;
import PAD.game.GameMode;
import PAD.interfaceKit.KitConnector;
import PAD.sound.Sound;
import PAD.sound.Speaker;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Youri Dudock
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class Main extends Application {
    
    public static Controller controller = new Controller();
    
    @Override
    public void start(Stage stage) throws IOException {

        InterfaceHandler.open(InterfaceName.MAIN);
    }
    

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
                
         KitConnector.initialize();
        launch(args);
        
        
    }

}