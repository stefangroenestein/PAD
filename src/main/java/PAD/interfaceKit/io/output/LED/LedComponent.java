/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output.LED;

import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.ComponentHandler;

/**
 * Functions for the led component
 *
 * @author Bobbie
 */
public class LedComponent extends ComponentHandler {
    
    private final String LED_PREFIX = "LIGHT_"; // the identifier to find the led in the component enum

    @Override
    public String getPrefix() {
        return LED_PREFIX;
    }
    
    /**
     * Turns on the led
     * 
     * @param color the color the led should be
     */
    public void turnOn(LedColor color){
        ComponentHandler.setState(Component.LIGHT_RED, color.getColorRed());
        ComponentHandler.setState(Component.LIGHT_GREEN, color.getColorGreen());
        ComponentHandler.setState(Component.LIGHT_BLUE, color.getColorBlue());
    }
}
