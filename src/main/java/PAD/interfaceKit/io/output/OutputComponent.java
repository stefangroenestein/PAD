/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output;

import PAD.interfaceKit.KitConnector;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.ComponentQueue;
import PAD.interfaceKit.component.QueuedComponent;
import com.phidgets.PhidgetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youri Dudock
 */
public class OutputComponent {

    public static void setState(Component component, boolean state) {
        ComponentQueue.add(component, state);
    }

    public static void process() {
        while (ComponentQueue.hasNext()) {
            
            try {
                QueuedComponent queuedComponent = ComponentQueue.getNext();
                KitConnector.getKit().setOutputState(queuedComponent.getComponent().getId(), queuedComponent.getState());
                
            } catch (PhidgetException ex) {
                Logger.getLogger(OutputComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
