/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

import java.util.ArrayList;

/**
 * Contains a queue which holds output components that need their state changed, we process the queue as the last action in our tick based cycle
 *
 * @author Youri Dudock
 */
public class ComponentQueue {
    
    private static ArrayList<QueuedComponent> queue = new ArrayList(); // list with components and their new state
    
    /**
     * Adds a component and the state the component should be in to our Queue
     * 
     * @param component
     * @param state 
     */
    public static void add(Component component, boolean state) {
        QueuedComponent queuedComponent = new QueuedComponent(component, state);
        
        queue.add(queuedComponent);
    }
    
    /**
     * Gives us back the first item in the queue and removes it after
     * Note that the method '#hasNext' should be used in order to prevent outOfRange exceptions
     * 
     * @return the next component in the queue
     */
    public static QueuedComponent getNext() {
        QueuedComponent queuedComponent = queue.get(0);
        queue.remove(0);
        
        return queuedComponent;
    }
    
    /**
     * Checks if the queue has a next
     * 
     * @return if there is another item in the queue
     */
    public static boolean hasNext() {
        return queue.size() >= 1;
    }

    /**
     * Gets the whole queue 
     * 
     * @return gets the queue as array list
     */
    public static ArrayList<QueuedComponent> getQueue() {
        return queue;
    }
    
    
}
