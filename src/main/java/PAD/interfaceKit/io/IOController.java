/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io;

import PAD.interfaceKit.component.ComponentHandler;
import PAD.interfaceKit.io.output.OutputHandler;
import PAD.interfaceKit.io.input.InputHandler;
import PAD.interfaceKit.io.input.button.ButtonComponent;

/**
 * Channels the input and output to the right handlers
 *
 * @author Youri Dudock
 */
public abstract class IOController {

    private static IOController inputHandler = new InputHandler(); // the input handler

    private static IOController outputHandler = new OutputHandler(); // the output handler

    /**
     * Sets a action to read input
     */
    public static void in() {
        inputHandler.onPulse(IOType.INPUT);
    }

    /**
     * Sets a action to output output
     */
    public static void out() {
        outputHandler.onPulse(IOType.OUTPUT);
    }

    /**
     * Gets called every tick
     *
     * @param type if its input or output
     */
    public abstract void onPulse(IOType type);

}
