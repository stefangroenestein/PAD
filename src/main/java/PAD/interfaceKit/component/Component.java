/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

import PAD.interfaceKit.io.input.button.impl.GreenButtonAction;
import PAD.interfaceKit.io.input.pressure.impl.PressurePlateAction;

/**
 *
 * @author Youri Dudock
 */
public enum Component {
    
    BUTTON_GREEN(0, new GreenButtonAction()),
    
    PRESSURE_PLATE_ONE(1, new PressurePlateAction());
    
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
