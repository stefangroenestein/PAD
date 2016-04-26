/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input.pressure.impl;

import PAD.game.GameHandler;
import PAD.game.GameStage;
import PAD.game.mechanic.PistonMechanic;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.ComponentAction;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.interfaceKit.component.LinkedComponent;

/**
 *
 * @author Youri Dudock
 */
public class PressurePlateAction implements ComponentAction {

    private LinkedComponent linkedComponent;
    
    private int magnetId, pressureId;
    
    

    @Override
    public void trigger() {
        System.out.println("A pressure plate is being triggered!");
        
        linkedComponent = LinkedComponent.values()[magnetId];
        
 
        
        if (linkedComponent == null || linkedComponent.getPressurePlate() == null) {
            
            if (linkedComponent == null) {
                System.out.println("linked");
                        
            }
            
            if (linkedComponent.getPressurePlate() == null) {
                System.out.println("pressure is null");
            }
            
            return;
        }
        
        
        
        

        if (GameHandler.getGame().getStage().equals(GameStage.WAITING_FOR_PISTON)) { // if the game is waiting for the pistons to be pressed down

            if (!PistonMechanic.getPistonsDown().contains(linkedComponent.getPressurePlate())) { // If this is a new entry
                PistonMechanic.getPistonsDown().add(linkedComponent.getPressurePlate());
                System.out.println("Pressure plate added to list with id: " + linkedComponent.getPressurePlate().getId());
            }
        }

        if (GameHandler.getGame().getStage().equals(GameStage.RUNNING)) {

            if (GameHandler.getGame().getReleasedPiston() == null) { // prevent nullpointer exception
                return;
            }

            if (GameHandler.getGame().getReleasedPiston().equals(linkedComponent)) {
                System.out.println("Right piston has been pressed down, releasing new..");

                PistonMechanic.releasePiston(ComponentHandler.getRandomLinkedComponent());
            } else {
                System.out.println("Wrong piston has been pressed down.");
            }

        }

    }

    public PressurePlateAction(int magnetId, int pressureId) {
        this.magnetId = magnetId;
        this.pressureId = pressureId;
    }

}
