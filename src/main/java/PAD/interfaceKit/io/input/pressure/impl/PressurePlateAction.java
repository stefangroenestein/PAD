/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input.pressure.impl;

import PAD.main.debug.Debugger;
import PAD.game.GameHandler;
import PAD.game.GameStage;
import PAD.game.mechanic.PistonMechanic;
import PAD.interfaceKit.component.ComponentAction;
import PAD.interfaceKit.component.ComponentSound;
import PAD.interfaceKit.component.LinkedComponent;

/**
 * The pressure plate action
 *
 * @author Youri Dudock
 */
public class PressurePlateAction implements ComponentAction {

    private LinkedComponent linkedComponent; // the linked component which selects the magnet and pressure plate of the piston

    private int linkedComponentIndex; // the index of the linked component in the enum

    /**
     * Constructor for this action
     *
     * @param linkedComponentIndex the index in the linked component enum
     */
    public PressurePlateAction(int linkedComponentIndex) {
        this.linkedComponentIndex = linkedComponentIndex;
    }

    /**
     * Gets called when the action is triggered
     */
    @Override
    public void trigger() {

        if (PistonMechanic.isReleaseBlocked()) { // we cannot do any action if we are release blocked
            return;
        }

        linkedComponent = LinkedComponent.values()[linkedComponentIndex]; // gets the linked component by using the index

        if (GameHandler.getGame().getStage().equals(GameStage.WAITING_FOR_PISTON)) { // if the game is waiting for the pistons to be pressed down

            if (!PistonMechanic.getPistonsDown().contains(linkedComponent.getPressurePlate())) { // If this is a new entry
                PistonMechanic.getPistonsDown().add(linkedComponent.getPressurePlate());

                Debugger.write("Pressure plate added to list with id: " + linkedComponent.getPressurePlate().getId());
            }

        } else if (GameHandler.getGame().getStage().equals(GameStage.RUNNING)) { // if the game is running

            if (GameHandler.getGame().getReleasedPiston() == null) { // prevent nullpointer exception
                return;
            }

            if (GameHandler.getGame().getReleasedPiston().equals(linkedComponent)) { // if the correct piston has been pressed down
                PistonMechanic.correctPistonPressed(ComponentSound.values()[linkedComponentIndex]); // calls a function on correct piston
            }

        }

    }

}
