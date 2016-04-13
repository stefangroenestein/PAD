/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input;

import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.io.IOController;

/**
 *
 * @author Youri Dudock
 */
public class InputHandler extends IOController {
    
    @Override
    public void onPulse() {
        InputComponent.getButtonComponent().process();
        InputComponent.getPressurePlateComponent().process();
    }
    
    
    
}
