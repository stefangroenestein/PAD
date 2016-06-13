/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main;

import PAD.game.GameHandler;
import PAD.interfaceKit.io.IOController;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.main.task.TaskManager;
import com.phidgets.PhidgetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controls the sequence of our application this class implements the Runneable
 * interface because its run on its own thread
 *
 * @author Youri Dudock
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class Controller implements Runnable {

    private boolean isRunning = true; // if the main loop is running

    private final int SLEEP_TIMER = 400; // the amount of sleep (delay) between two ticks

    /**
     * The main function that contains a loop that keeps running while isRunning
     * is true also controls the sequence of the processes
     *
     * @throws InterruptedException
     * @throws PhidgetException
     */
    public void control() throws InterruptedException, PhidgetException {

        while (isRunning) {

            IOController.in(); // reads and processes the input

            GameHandler.process(); // deals with the game process

            TaskManager.process(); // deals with the task process

            IOController.out(); // reads the component queue and performs output 

            Thread.sleep(SLEEP_TIMER); // sleeps
        }

    }

    /**
     * Starts the controller
     */
    public void start() {
        try {
            ComponentHandler.initialize(); // inits all the set components

            control(); // starts controlling

        } catch (InterruptedException | PhidgetException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Stops the controller from running
     */
    public void stop() {
        isRunning = false;
    }

    /**
     * Starts running the controller from the Runnable interface
     */
    @Override
    public void run() {
        start();
    }

}
