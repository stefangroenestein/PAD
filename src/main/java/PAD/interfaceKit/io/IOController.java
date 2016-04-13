/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io;

import PAD.interfaceKit.io.input.InputComponent;
import PAD.interfaceKit.io.output.OutputHandler;
import PAD.interfaceKit.io.input.InputHandler;
import PAD.interfaceKit.io.input.button.ButtonComponent;

/**
 *
 * @author Youri Dudock
 */
public abstract class IOController {
    
    private static IOController inputHandler = new InputHandler();
    
    private static IOController outputHandler = new OutputHandler();
    
    /**
     * Sets a action to read input 
     */
    public static void in() {
        inputHandler.onPulse();
    }
    
    /**
     * Sets a action to output output
     */
    public static void out() {
        outputHandler.onPulse();
    }
    
    
    public abstract void onPulse();

    
    
}
