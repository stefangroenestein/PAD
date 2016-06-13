/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

/**
 * A component which is waiting for processing
 *
 * @author Youri Dudock
 */
public class QueuedComponent {
    
    private Component component; // the selected component 
    
    private boolean state; // the state of which the component should be in
    
    /**
     * Constructor for this component
     * 
     * @param component the component in the queue
     * @param state the new state of this component
     */
    public QueuedComponent(Component component, boolean state) {
        this.component = component;
        this.state = state;
    }

    /**
     * 
     * @return the component in this queued component
     */
    public Component getComponent() {
        return component;
    }

    /**
     * 
     * @return the new state of this component
     */
    public boolean getState() {
        return state;
    }
    
}
