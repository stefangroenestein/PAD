/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit;

import static PAD.interfaceKit.SetOutput.magnet1Power;
import static PAD.interfaceKit.SetOutput.magnet2Power;
import static PAD.interfaceKit.SetOutput.magnet3Power;
import static PAD.interfaceKit.SetOutput.magnet4Power;
import static PAD.interfaceKit.SetOutput.magnet5Power;
import static PAD.interfaceKit.SetOutput.powerButton;
import PAD.interfaceKit.button.Button;
import PAD.interfaceKit.output.Output;
import com.phidgets.PhidgetException;

/**
 *
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class ShutDownProgram extends KitController {

    public static int EXIT_TIMER = 1000;
    
    @Override
    public void controller() throws PhidgetException {
       
            powerButton = KitConnector.getKit().getInputState(Button.WHITE.getId());
        
        if (powerButton) {

            magnet1Power = false;
            magnet2Power = false;
            magnet3Power = false;
            magnet4Power = false;
            magnet5Power = false;

            KitConnector.getKit().setOutputState(Output.MAGNET1.getId(), magnet1Power);
            KitConnector.getKit().setOutputState(Output.MAGNET2.getId(), magnet2Power);
            KitConnector.getKit().setOutputState(Output.MAGNET3.getId(), magnet3Power);
            KitConnector.getKit().setOutputState(Output.MAGNET4.getId(), magnet4Power);
            KitConnector.getKit().setOutputState(Output.MAGNET5.getId(), magnet5Power);

            System.out.println("Closing program...");
            System.exit(EXIT_TIMER);
        }
    }
}
