/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output.magnet;

import PAD.main.util.RandomUtil;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.io.output.OutputComponent;
import java.util.ArrayList;

/**
 *
 * @author Youri Dudock
 */
public class MagnetHandler {

    private final static String MAGNET_PREFIX = "MAGNET_";

    private static ArrayList<Component> magnets = new ArrayList();

    public MagnetHandler() {
        for (Component component : Component.values()) {

            if (component.toString().startsWith(MAGNET_PREFIX)) {
                magnets.add(component);
            }
        }
    }

    /**
     * Sets the state of all the magnets in the game
     *
     * @param state state the magnet should be put into
     */
    public static void setMagnets(boolean state) {
        for (Component magnet : magnets) {
            OutputComponent.setState(magnet, state);
        }
    }
    
    /**
     * Gets a random magnet from our list
     * 
     * @return a magnet component
     */
    public static Component getRandomMagnet() {
        return magnets.get(RandomUtil.getRandomInt(magnets.size()));
    }

}
