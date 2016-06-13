/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

import PAD.interfaceKit.io.input.pressure.impl.PressurePlateAction;
import PAD.interfaceKit.io.output.magnet.MagnetAction;

/**
 * Contains all the components that are connected to our application trough the
 * interface kit
 *
 * @author Youri Dudock
 */
public enum Component {

    PRESSURE_PLATE_ONE(3, new PressurePlateAction(0)), // a pressure plate that triggers when a piston is pressed on it
    PRESSURE_PLATE_TWO(4, new PressurePlateAction(1)),
    PRESSURE_PLATE_THREE(5, new PressurePlateAction(2)),
    PRESSURE_PLATE_FOUR(6, new PressurePlateAction(3)),
    PRESSURE_PLATE_FIVE(7, new PressurePlateAction(4)),
    
    MAGNET_ONE(0, new MagnetAction()), // a magnet that holds and releases the pistons
    MAGNET_TWO(1, new MagnetAction()),
    MAGNET_THREE(2, new MagnetAction()),
    MAGNET_FOUR(3, new MagnetAction()),
    MAGNET_FIVE(4, new MagnetAction()),
    
    LIGHT_BLUE(5, null), // the led lights
    LIGHT_RED(6, null),
    LIGHT_GREEN(7, null);

    private int id; // the interface kit id of this component

    private ComponentAction action; // the action linked to this component

    /**
     *
     * @param id id of the component
     * @param action action of this component
     */
    private Component(int id, ComponentAction action) {
        this.id = id;
        this.action = action;
    }

    /**
     *
     * @return if of the component
     */
    public int getId() {
        return id;
    }

    /**
     * Performs the action linked with this component
     */
    public void doAction() {
        action.trigger();
    }

}
