/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

import PAD.main.util.RandomUtil;
import java.util.ArrayList;

/**
 *
 * @author Youri Dudock
 */
public class ComponentHandler {

    private static ArrayList<LinkedComponent> linkedComponents = new ArrayList();
    
    public ComponentHandler() {
        for (LinkedComponent linkedComponent : LinkedComponent.values()) {
            linkedComponents.add(linkedComponent);
        }
    }
    
    public static LinkedComponent getRandomLinkedComponent() {
         return linkedComponents.get(RandomUtil.getRandomInt(linkedComponents.size()));
    }
    
}
