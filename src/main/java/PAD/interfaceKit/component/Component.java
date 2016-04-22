/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

import PAD.interfaceKit.io.input.button.impl.GreenButtonAction;
import PAD.interfaceKit.io.input.pressure.impl.PressurePlateAction;
import PAD.interfaceKit.io.output.magnet.MagnetAction;

/**
 *
 * @author Youri Dudock
 */
public enum Component {
    
    BUTTON_GREEN(0, new GreenButtonAction()),
    
    PRESSURE_PLATE_ONE(1, new PressurePlateAction(LinkedComponent.ONE)),
    
    MAGNET_ONE(6, new MagnetAction());
    
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
