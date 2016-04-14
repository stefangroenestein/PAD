/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input.pressure.impl;

import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.ComponentAction;
import PAD.interfaceKit.io.output.OutputComponent;

/**
 *
 * @author Youri Dudock
 */
public class PressurePlateAction implements ComponentAction {

    @Override
    public void trigger() {
        System.out.println("Pressure plate is being triggered!");

        OutputComponent.setState(Component.MAGNET_ONE, true);
    }
    
}
