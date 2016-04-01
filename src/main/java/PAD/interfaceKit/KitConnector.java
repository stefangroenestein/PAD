/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit;

import com.phidgets.InterfaceKitPhidget;
import com.phidgets.PhidgetException;

/**
 *
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class KitConnector {

    private static InterfaceKitPhidget kit;
    private static final int WAIT_TIMER = 5000;

    public static InterfaceKitPhidget getKit() throws PhidgetException {
        if (kit == null) {
            kit = new InterfaceKitPhidget();
        }

        if (!kit.isAttached()) {
            kitConnect();
        }

        return kit;
    }

    private static void kitConnect() {
        try {
            kit.openAny();
            System.out.println("Waiting for InterfaceKit...");
            kit.waitForAttachment(WAIT_TIMER);
            System.out.println("InterfaceKit connected!");

        } catch (PhidgetException ex) {
            System.err.println("Unable to create InterfaceKit");
        }
    }

    public static void initialize() {
        kitConnect();
    }
}
