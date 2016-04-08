/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit;

import PAD.interfaceKit.output.Output;
import com.phidgets.PhidgetException;

/**
 *
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class SetOutput extends KitController {

    public static int magnet1 = 1;
    public static int magnet2 = 2;
    public static int magnet3 = 3;
    public static int magnet4 = 4;
    public static int magnet5 = 5;

    public static int random;

    public static boolean magnet1Power;
    public static boolean magnet2Power;
    public static boolean magnet3Power;
    public static boolean magnet4Power;
    public static boolean magnet5Power;

    public static int SLEEP_TIMER = 1000;

    public static boolean powerButton;

    public static boolean isRunning = false;

    @Override
    public void controller() throws PhidgetException, InterruptedException {

        int max = 5;
        int min = 1;
        
        while (isRunning) {
            random = (int) (Math.random() * max) + min;

            if (SetOutput.random == magnet1) {
                magnet1Power = false;
                System.out.println("Magnet 1: Uit");
            } else {
                magnet1Power = true;
                System.out.println("Magnet 1: Aan");
            }

            if (SetOutput.random == magnet2) {
                magnet2Power = false;
                System.out.println("Magnet 2: Uit");
            } else {
                magnet2Power = true;
                System.out.println("Magnet 2: Aan");
            }

            if (SetOutput.random == magnet3) {
                magnet3Power = false;
                System.out.println("Magnet 3: Uit");
            } else {
                magnet3Power = true;
                System.out.println("Magnet 3: Aan");
            }

            if (SetOutput.random == magnet4) {
                magnet4Power = false;
                System.out.println("Magnet 4: Uit");
            } else {
                magnet4Power = true;
                System.out.println("Magnet 4: Aan");
            }

            if (SetOutput.random == magnet5) {
                magnet5Power = false;
                System.out.println("Magnet 5: Uit");
            } else {
                magnet5Power = true;
                System.out.println("Magnet 5: Aan");
            }

            KitConnector.getKit().setOutputState(Output.MAGNET1.getId(), SetOutput.magnet1Power);
            KitConnector.getKit().setOutputState(Output.MAGNET2.getId(), SetOutput.magnet2Power);
            KitConnector.getKit().setOutputState(Output.MAGNET3.getId(), SetOutput.magnet3Power);
            KitConnector.getKit().setOutputState(Output.MAGNET4.getId(), SetOutput.magnet4Power);
            KitConnector.getKit().setOutputState(Output.MAGNET5.getId(), SetOutput.magnet5Power);

            Thread.sleep(SLEEP_TIMER);
        }
    }
}