/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main;

import PAD.Main.debug.Debugger;
import PAD.game.GameHandler;
import PAD.game.GameMode;
import PAD.interfaceKit.io.IOController;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.main.task.TaskManager;
import com.phidgets.PhidgetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youri Dudock
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class Controller implements Runnable {
    
    private boolean isRunning = true;
    
    private final int SLEEP_TIMER = 400;
   
    public void control() throws InterruptedException, PhidgetException {

        while (isRunning) {
            
            IOController.in();
            
            GameHandler.process();
            
            TaskManager.process();
            
            IOController.out();
            
            Thread.sleep(SLEEP_TIMER); 
        }

    }
    
    public void start() {
        try {
            ComponentHandler.initialize();    
            
            GameHandler.startGame(GameMode.TIMED_EASY);
            
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

    @Override
    public void run() {
        start();
    }

}
