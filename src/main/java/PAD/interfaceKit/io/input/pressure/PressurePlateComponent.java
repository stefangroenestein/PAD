/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input.pressure;

import PAD.game.GameHandler;
import PAD.game.GameStage;
import PAD.game.mechanic.PistonMechanic;
import PAD.interfaceKit.KitConnector;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.main.debug.Debugger;
import com.phidgets.PhidgetException;

/**
 * Deals with the pressure plate component, a pressure plates gives us a value of the amount of pressure on it
 *
 * @author Youri Dudock
 */
public class PressurePlateComponent extends ComponentHandler {
    
    private final String PRESSURE_PLATE_PREFIX = "PRESSURE_PLATE_"; // the prefix to find the pressure plate
    
    private final int SENSOR_TRIGGER_VALUE = 1; // the total amount of pressure needed in order to perform a trigger action
    
    private final int SENSOR_TRIGGER_VALUE_WRONG = 800; // if a wrong piston gets triggered this is the trigger value for it

    @Override
    public String getPrefix() {
        return PRESSURE_PLATE_PREFIX;
    }
    
    /**
     * Gets the state of the pressure plate 
     * 
     * @param component
     *                the component being checked
     * @return true if the plate has been triggered
     */
    @Override
    public boolean getState(Component component) {
        try { 
            int pressureValue = KitConnector.getKit().getSensorValue(component.getId()); // gets the pressure value of the pressure plate
            
            if (component.equals(Component.PRESSURE_PLATE_FOUR)) {
                System.out.println("Pressure value: " + pressureValue);
            }
            
            if (pressureValue >= SENSOR_TRIGGER_VALUE_WRONG) { // check if the wrong piston has been pressed
                
                
                
                if (GameHandler.getGame().getStage().equals(GameStage.RUNNING)) { // check if the game is running
                    if (!GameHandler.getGame().getReleasedPiston().getPressurePlate().equals(component)) { // check if the pressure plate is the wrong one
                        PistonMechanic.wrongPistonPressed(); // trigger wrongPistonHook
                    }
                }
                
            }

            return pressureValue >= SENSOR_TRIGGER_VALUE;
        } catch (Exception ex) {
            Debugger.write("Error while reading pressure plate: " + component.toString());
            return false;
        }
    }


    
}
