/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game.mechanic;

import PAD.game.GameHandler;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.LinkedComponent;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.main.task.TaskManager;
import PAD.main.task.tasks.CancelBlockedStateTask;
import PAD.main.task.tasks.ChangeMagnetStateTask;
import java.util.ArrayList;

/**
 * Contains mechanics for the pistons
 *
 * @author Youri Dudock
 */
public class PistonMechanic {
    
    private static ArrayList<Component> pistonsDown = new ArrayList(); // list with the pistons that are down
    
    private static final int TOTAL_PISTONS = ComponentHandler.getMagnet().getComponents().size(); // total amount of pistons based on amount of magnets
    
    private static boolean isReleaseBlocked = false;
    
    /**
     * Releases the piston by turning off a magnet
     * 
     * @param linkedComponent 
     *                       The linked component which contains the id of the magnet and the connected pressure plate
     */
    public static void releasePiston(LinkedComponent linkedComponent) {
        if (isReleaseBlocked) { // if the pistons are in a locked state (wait timer)
            return;
        }
        
        isReleaseBlocked = true;
        
        ComponentHandler.setState(linkedComponent.getMagnet(), false); // release the piston
        
        GameHandler.getGame().setReleasedPiston(linkedComponent); // sets the new released piston
        
        TaskManager.start(new ChangeMagnetStateTask(linkedComponent.getMagnet(), true, 1));
        TaskManager.start(new CancelBlockedStateTask());
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
    
    public static void setReleaseBlocked(boolean state) {
        isReleaseBlocked = state;
    }
    
    public static boolean isReleaseBlocked() {
        return isReleaseBlocked;
    }
     
}
