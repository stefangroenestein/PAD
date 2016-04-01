/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit;

import PAD.interfaceKit.button.Button;
import PAD.interfaceKit.output.Output;
import com.phidgets.PhidgetException;

/**
 *
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class KitController {

    private final int SLEEP_TIMER = 1000;
    private final int EXIT_TIMER = 1000;
    private boolean isRunning = false;

    public KitController() {
        KitConnector.initialize();
    }

    public void start() throws InterruptedException, PhidgetException {
        controller();
    }

    @SuppressWarnings("SleepWhileInLoop")
    public void controller() throws InterruptedException, PhidgetException {

        boolean button;
        boolean powerButton;
        boolean magnet;

        while (isRunning) {

            button = KitConnector.getKit().getInputState(Button.GREEN.getId());
            powerButton = KitConnector.getKit().getInputState(Button.WHITE.getId());

            if (button) {
                magnet = false;
                System.out.println("Uit");
            } else {
                magnet = true;
                System.out.println("Aan");
            }

            KitConnector.getKit().setOutputState(Output.MAGNET.getId(), magnet);

            if (powerButton) {
                magnet = false;
                KitConnector.getKit().setOutputState(Output.MAGNET.getId(), magnet);
                System.out.println("Closing program...");
                System.exit(EXIT_TIMER);
            }

            Thread.sleep(SLEEP_TIMER);
        }
    }
}
