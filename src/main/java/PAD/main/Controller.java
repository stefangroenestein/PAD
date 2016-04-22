/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main;

import PAD.game.GameHandler;
import PAD.interfaceKit.io.IOController;
import PAD.interfaceKit.io.input.InputComponent;
import com.phidgets.PhidgetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youri Dudock
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class Controller {
    
    private static boolean isRunning = true;
   
    public void control() throws InterruptedException, PhidgetException {

        while (isRunning) {
            IOController.in();
            
            GameHandler.process();
            
            IOController.out();

            Thread.sleep(500); // for now
        }

    }
    
    public void start() {
        try {
 
            InputComponent.initialize();
            control();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PhidgetException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stop() {
        isRunning = false;
    }

}
