/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

import PAD.interfaceKit.io.input.button.ButtonComponent;
import PAD.interfaceKit.io.input.button.impl.GreenButtonAction;
import PAD.interfaceKit.io.input.pressure.PressurePlateComponent;
import PAD.interfaceKit.io.input.pressure.impl.PressurePlateAction;
import PAD.interfaceKit.io.output.magnet.MagnetAction;
import PAD.interfaceKit.io.output.magnet.MagnetComponent;

/**
 *
 * @author Youri Dudock
 */
public enum Component {
    
    PRESSURE_PLATE_ONE(3, new PressurePlateAction(0)),
    PRESSURE_PLATE_TWO(4, new PressurePlateAction(1)),
    PRESSURE_PLATE_THREE(5, new PressurePlateAction(2)),
    PRESSURE_PLATE_FOUR(6, new PressurePlateAction(3)),
    PRESSURE_PLATE_FIVE(7, new PressurePlateAction(4)),
    
    MAGNET_ONE(0, new MagnetAction()),
    MAGNET_TWO(1, new MagnetAction()),
    MAGNET_THREE(2, new MagnetAction()),
    MAGNET_FOUR(3, new MagnetAction()),
    MAGNET_FIVE(4, new MagnetAction());
    
    
    private int id;
    
    private ComponentAction action;
    
    
    private Component(int id, ComponentAction action) {
        this.id = id;
        this.action = action;
    }
    
    public int getId() {
        return id;
    }

    public void doAction() {
        action.trigger();
    }
    
    
    
   
    
}
