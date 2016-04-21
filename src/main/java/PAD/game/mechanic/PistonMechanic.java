/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game.mechanic;

import PAD.game.GameHandler;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.LinkedComponent;
import PAD.interfaceKit.io.input.InputComponent;
import PAD.interfaceKit.io.output.OutputComponent;

/**
 *
 * @author Youri Dudock
 */
public class PistonMechanic {
    
    public static void releasePiston(LinkedComponent linkedComponent) {
        OutputComponent.setState(linkedComponent.getMagnet(), false); // release the piston
        
        GameHandler.getGame().setReleasedPiston(linkedComponent);
        
        OutputComponent.setState(linkedComponent.getMagnet(), true); // turn the magnet back on so that the piston can be catched
    }
    
    public static boolean arePistonsDown() {
        int pressurePlates = 0; // amount of pressure plates in the system
        int activatedPlates = 0; // amount of activated plates

        for (Component component : Component.values()) {

            if (component.toString().startsWith(InputComponent.getPressurePlateComponent().getPrefix())) {
                pressurePlates++;

                if (InputComponent.getPressurePlateComponent().getState(component)) {
                    activatedPlates++;
                }
            }
        }

        return activatedPlates == pressurePlates;
    }
    
}
