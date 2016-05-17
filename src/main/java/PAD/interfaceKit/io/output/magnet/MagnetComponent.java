/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output.magnet;

import PAD.main.debug.Debugger;
import PAD.main.util.RandomUtil;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.ComponentHandler;

/**
 * Deals with magnets as component
 *
 * @author Youri Dudock
 */
public class MagnetComponent extends ComponentHandler {

    private final String MAGNET_PREFIX = "MAGNET_"; // the identifier to find the magnets in the component enum
    

    /**
     * Sets the state of all the magnets in the game
     *
     * @param state state the magnet should be put into
     */
    public void setMagnets(boolean state) {
        for (Component magnet : getComponents()) {
            ComponentHandler.setState(magnet, state);
        }
        
        Debugger.write("Turning all the magnets to state: " + state);
    }
    
    /**
     * Gets a random magnet from our list
     * 
     * @return a magnet component
     */
    public Component getRandomMagnet() {
        return getComponents().get(RandomUtil.getRandomInt(getComponents().size()));
    }
    
    @Override
    public String getPrefix() {
        return MAGNET_PREFIX;
    }
    
    

}
