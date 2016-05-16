/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input.pressure.impl;

import PAD.Main.debug.Debugger;
import PAD.game.GameHandler;
import PAD.game.GameStage;
import PAD.game.mechanic.PistonMechanic;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.ComponentAction;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.interfaceKit.component.LinkedComponent;
import PAD.main.Main;
import PAD.sound.Sound;
import PAD.sound.Speaker;

/**
 *
 * @author Youri Dudock
 */
public class PressurePlateAction implements ComponentAction {

    private LinkedComponent linkedComponent;

    private int linkedComponentIndex;

    @Override
    public void trigger() {
        
        if (PistonMechanic.isReleaseBlocked()) {
            return;
        }
        
        linkedComponent = LinkedComponent.values()[linkedComponentIndex];

        if (GameHandler.getGame().getStage().equals(GameStage.WAITING_FOR_PISTON)) { // if the game is waiting for the pistons to be pressed down

            if (!PistonMechanic.getPistonsDown().contains(linkedComponent.getPressurePlate())) { // If this is a new entry
                PistonMechanic.getPistonsDown().add(linkedComponent.getPressurePlate());

                Debugger.write("Pressure plate added to list with id: " + linkedComponent.getPressurePlate().getId());
            }

        } else if (GameHandler.getGame().getStage().equals(GameStage.RUNNING)) {

            if (GameHandler.getGame().getReleasedPiston() == null) { // prevent nullpointer exception
                return;
            }
           
            if (GameHandler.getGame().getReleasedPiston().equals(linkedComponent)) {

                Debugger.write("Correct pressure plate has been pressed with ID: " + (linkedComponentIndex + 1));
                
                GameHandler.getGame().getMode().getHandler().onCorrectPistonDownHook();

                Speaker.play(Sound.TEST);

                PistonMechanic.releasePiston(ComponentHandler.getRandomLinkedComponent());
            }

        }

    }

    public PressurePlateAction(int linkedComponentIndex) {
        this.linkedComponentIndex = linkedComponentIndex;
    }

}
