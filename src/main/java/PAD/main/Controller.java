/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main;

import PAD.game.GameHandler;
import PAD.game.GameMode;
import PAD.interfaceKit.io.IOController;
import PAD.interfaceKit.component.ComponentHandler;
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
            
            if (GameHandler.shouldTurnOn) {
                GameHandler.shouldTurnOn = false;
                ComponentHandler.setState(GameHandler.getGame().getReleasedPiston().getMagnet(), true); // turn the magnet back on so that the piston can be catched 
            }
            
            IOController.in();
            
            GameHandler.process();
            
            IOController.out();
            
            if (GameHandler.getGame().getReleasedPiston() != null) {
                System.out.println("Expecting piston: " + GameHandler.getGame().getReleasedPiston().getPressurePlate());
            }
            

            Thread.sleep(300); // for now
        }

    }
    
    public void start() {
        try {
 
            ComponentHandler.initialize();    
            GameHandler.startGame(GameMode.NORMAL);
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
