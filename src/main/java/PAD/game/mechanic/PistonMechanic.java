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
import java.util.ArrayList;

/**
 * Contains mechanics for the pistons
 *
 * @author Youri Dudock
 */
public class PistonMechanic {
    
    private static ArrayList<Component> pistonsDown = new ArrayList(); // list with the pistons that are down
    
    private static final int TOTAL_PISTONS = InputComponent.getPressurePlateComponent().getComponents().size(); // total amount of pistons
                                                                                                                // based on amount of pressure plates
    
    /**
     * Releases the piston by turning off a magnet
     * 
     * @param linkedComponent 
     *                       The linked component which contains the id of the magnet and the connected pressure plate
     */
    public static void releasePiston(LinkedComponent linkedComponent) {
        OutputComponent.setState(linkedComponent.getMagnet(), false); // release the piston
        
        GameHandler.getGame().setReleasedPiston(linkedComponent); // sets the new released piston
        
        OutputComponent.setState(linkedComponent.getMagnet(), true); // turn the magnet back on so that the piston can be catched
    }
    
    public static boolean arePistonsDown() {
        return TOTAL_PISTONS == pistonsDown.size();
    }
    
    
    /**
     * 
     * @return a list with pistons
     */
    public static ArrayList<Component> getPistonsDown() {
        return pistonsDown;
    }
     
}
