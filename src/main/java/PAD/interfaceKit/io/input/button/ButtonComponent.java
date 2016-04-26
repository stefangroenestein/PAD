/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input.button;

import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.KitConnector;
import PAD.interfaceKit.component.ComponentHandler;
import com.phidgets.PhidgetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Youri Dudock
 */
public class ButtonComponent extends ComponentHandler {
    
    private final String BUTTON_PREFIX = "BUTTON_";
    
    @Override
    public String getPrefix() {
        return BUTTON_PREFIX;
    }

    @Override
    public boolean getState(Component component) {
        try {
            return KitConnector.getKit().getInputState(component.getId());
        } catch (PhidgetException ex) {
            Logger.getLogger(ButtonComponent.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
