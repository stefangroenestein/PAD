/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output.LED;

import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.ComponentHandler;

/**
 *
 * @author Roosie
 */
public class LedComponent extends ComponentHandler{

    @Override
    public String getPrefix() {
        return "LIGHT_";
    }
    public void turnOn(LedColor color){
        ComponentHandler.setState(Component.LIGHT_RED, color.getColorRed());
        ComponentHandler.setState(Component.LIGHT_GREEN, color.getColorGreen());
        ComponentHandler.setState(Component.LIGHT_BLUE, color.getColorBlue());
    }
}
