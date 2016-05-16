/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input;

import PAD.interfaceKit.component.ComponentHandler;
import PAD.interfaceKit.io.IOController;
import PAD.interfaceKit.io.IOType;

/**
 * Deals with input from the components
 *
 * @author Youri Dudock
 */
public class InputHandler extends IOController {
    
    @Override
    public void onPulse(IOType type) {
        //ComponentHandler.getButton().process(type);
        ComponentHandler.getPressurePlate().process(type);
    }
    
    
    
}
