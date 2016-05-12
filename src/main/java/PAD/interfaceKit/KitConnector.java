/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit;

import com.phidgets.InterfaceKitPhidget;
import com.phidgets.PhidgetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Deals with connecting the kit to our program
 *
 * @author Youri Dudock
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class KitConnector {

    private static InterfaceKitPhidget kit; // a instance of the interface kit

    private static final int WAIT_TIMER = 5000; // the max amount of waiting time before disconnecting

    /**
     * Tries to connect the kit to our application
     */
    private static void connect() {
        try {
            kit.openAny(); // opens a connection with the kit

            System.out.println("Trying to connect the InterfaceKit... (Time out: " + WAIT_TIMER + ")");

            kit.waitForAttachment(WAIT_TIMER); // setting a wait timer

            System.out.println("InterfaceKit connected!"); // succes!
        } catch (PhidgetException ex) {
            System.err.println("Time out! Unable to connect in time with the InterfaceKit.");
            System.out.println("Attempting to reconnect..");

            initialize();
        }
    }

    /**
     * Creates a new kit instance and tries to connect it
     */
    public static void initialize() {
        try {
            kit = new InterfaceKitPhidget();
        } catch (PhidgetException ex) {
            Logger.getLogger(KitConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        connect();
    }

    /**
     *
     * @return a instance of our kit
     */
    public static InterfaceKitPhidget getKit() {
        return kit;
    }
}
