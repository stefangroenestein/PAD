/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input.pressure;

import PAD.interfaceKit.KitConnector;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.io.input.InputComponent;
import PAD.interfaceKit.io.input.button.ButtonComponent;
import com.phidgets.PhidgetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youri Dudock
 */
public class PressurePlateComponent extends InputComponent {
    
    private final String PRESSURE_PLATE_PREFIX = "PRESSURE_PLATE_";
    
    private final int SENSOR_TRIGGER_VALUE = 10;

    @Override
    public String getPrefix() {
        return PRESSURE_PLATE_PREFIX;
    }
    
    @Override
    public boolean getState(Component component) {
        try {
            return KitConnector.getKit().getSensorValue(component.getId()) >= SENSOR_TRIGGER_VALUE;
        } catch (PhidgetException ex) {
            Logger.getLogger(ButtonComponent.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
