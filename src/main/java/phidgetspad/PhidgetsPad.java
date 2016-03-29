package phidgetspad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.phidgets.InterfaceKitPhidget;
import com.phidgets.PhidgetException;

/**
 *
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class PhidgetsPad {

    static boolean magneet = true;
    static InterfaceKitPhidget kit;

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        kit = new InterfaceKitPhidget();
        interfaceKitConnect();
        control();
    }

    public static void interfaceKitConnect() throws Exception {
        try {
            kit.openAny();
            System.out.println("Waiting for InterfaceKit...");
            kit.waitForAttachment(5000);
            System.out.println("InterfaceKit connected!");

        } catch (PhidgetException ex) {
            System.err.println("Unable to create InterfaceKit");
            throw ex;
        }
    }

    @SuppressWarnings("SleepWhileInLoop")
    public static void control() throws Exception {
        boolean knop;
 
        while (true) {
            knop = kit.getInputState(0);

            if (knop) {
                magneet = false;
                System.out.println("Uit");
            } else {
                magneet = true;
                System.out.println("Aan");
            }
            kit.setOutputState(6, magneet);
            closeProgram();
            Thread.sleep(1000);
        }
    }

    public static void closeProgram() throws Exception {
        boolean knop2;
        knop2 = kit.getInputState(1);
        if (knop2) {
            magneet = false;
            kit.setOutputState(6, magneet);
            System.out.println("Closing program...");
            System.exit(0);
        }

    }
}
