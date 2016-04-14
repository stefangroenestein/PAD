/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output;

import PAD.interfaceKit.KitConnector;
import PAD.interfaceKit.io.IOController;

/**
 *
 * @author Youri Dudock
 */
public class OutputHandler extends IOController {
    
    @Override
    public void onPulse() {
        OutputComponent.process();
    }
    
}
