/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit;

import com.phidgets.PhidgetException;

/**
 *
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class KitController {

    public KitController() {
        KitConnector.initialize();
    }

    public void start() throws InterruptedException, PhidgetException {
        controller();
    }

    public void controller() throws InterruptedException, PhidgetException {
        
    }
}
