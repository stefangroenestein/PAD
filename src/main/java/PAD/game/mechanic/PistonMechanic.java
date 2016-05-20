/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game.mechanic;

import PAD.game.GameHandler;
import PAD.game.GameStage;
import PAD.main.task.tasks.ChangeReleasedPistonTask;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.LinkedComponent;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.interfaceKit.io.output.LED.LedColor;
import PAD.main.task.TaskManager;
import PAD.main.task.tasks.CancelBlockedStateTask;
import PAD.main.task.tasks.ChangeMagnetStateTask;
import PAD.sound.Sound;
import PAD.sound.Speaker;
import java.util.ArrayList;

/**
 * Contains mechanics for the pistons
 *
 * @author Youri Dudock
 * @author Bobbie
 */
public class PistonMechanic {

    private static ArrayList<Component> pistonsDown = new ArrayList(); // list with the pistons that are down (used to check if they are all down)

    private static final int TOTAL_PISTONS = ComponentHandler.getMagnet().getComponents().size(); // total amount of pistons based on amount of magnets

    private static boolean isReleaseBlocked = false; // if the releasing of new pistons is possible
    
    private static int ledRotationCount = 0; // rotation index of the led

    /**
     * Releases the piston by turning off a magnet
     *
     * @param linkedComponent The linked component which contains the id of the
     * magnet and the connected pressure plate
     */
    public static void releasePiston(LinkedComponent linkedComponent) {
        if (isReleaseBlocked) { // if the pistons are in a locked state (wait timer)
            return;
        }

        isReleaseBlocked = true; // prevent multiple releases

        ComponentHandler.setState(linkedComponent.getMagnet(), false); // release the piston

        TaskManager.start(
                new ChangeMagnetStateTask(linkedComponent.getMagnet(), true, 2),
                new ChangeReleasedPistonTask(linkedComponent, 2),
                new CancelBlockedStateTask(3)
        );
    }

    /**
     * Gets called when the correct piston has been pressed down
     */
    public static void correctPistonPressed() {
        Speaker.play(Sound.TEST); // play a sound

        if (ledRotationCount  == 0) { 
            ComponentHandler.getLed().turnOn(LedColor.RED);
            ledRotationCount ++;
        } else if (ledRotationCount  == 1) {
            ComponentHandler.getLed().turnOn(LedColor.GREEN);
            ledRotationCount ++;
        } else if (ledRotationCount  == 2) {
            ComponentHandler.getLed().turnOn(LedColor.BLUE);
            ledRotationCount  = 0;
        }

        GameHandler.getGame().getMode().getHandler().onCorrectPistonDownHook();
        
        releasePiston(ComponentHandler.getRandomLinkedComponent());
    }

    /**
     * Gets triggered once the wrong piston has been pressed down
     */
    public static void wrongPistonPressed() {
        Speaker.play(Sound.TEST); // play a error sound

        GameHandler.getGame().getMode().getHandler().onWrongPistonPressedHook(); // calls a hook for the games (maybe to decrease points etc)
    }

    /**
     *
     * @return if all the pistons are down
     */
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

    /**
     * Sets the state of the release block
     *
     * @param state
     */
    public static void setReleaseBlocked(boolean state) {
        isReleaseBlocked = state;
    }

    /**
     *
     * @return if the piston is release blocked or not
     */
    public static boolean isReleaseBlocked() {
        return isReleaseBlocked;
    }

}
