/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.GUI;

/**
 *
 * @author max
 */
import PAD.main.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author max
 */
public class InterfaceHandler {
    
    public  static void open(InterfaceName name){
        try {
            Parent root = FXMLLoader.load(new Main().getClass().getResource(name.getFileName()));
            
            Scene scene = new Scene(root);
            
            name.getStage().setScene(scene);
            name.getStage().show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceHandler.class.getName()).log(Level.SEVERE, null, ex);
        }


}
    
    
    public static void close(InterfaceName name) {
        name.getStage().close();
    }
}