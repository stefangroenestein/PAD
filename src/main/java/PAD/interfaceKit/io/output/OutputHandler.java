/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output;

import PAD.interfaceKit.component.ComponentHandler;
import PAD.interfaceKit.io.IOController;
import PAD.interfaceKit.io.IOType;

/**
 * Deals with output components
 * 
 * @author Youri Dudock
 */
public class OutputHandler extends IOController {
    
    @Override
    public void onPulse(IOType type) {
        ComponentHandler.getMagnet().process(type); // process output for magnets (this line also does it for other output components)
    }
    
}
