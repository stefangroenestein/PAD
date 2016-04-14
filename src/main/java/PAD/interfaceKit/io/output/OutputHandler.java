/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output;

import PAD.interfaceKit.KitConnector;
import PAD.interfaceKit.io.IOController;
import com.phidgets.PhidgetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youri Dudock
 */
public class OutputHandler extends IOController {
    
    //KitConnector.getKit().setOutputState(id, state);
    
    @Override
    public void onPulse() {
        OutputComponent.process();
    }
    
}
