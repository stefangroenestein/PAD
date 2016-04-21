/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input;

import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.io.input.button.ButtonComponent;
import PAD.interfaceKit.io.input.pressure.PressurePlateComponent;
import java.util.ArrayList;

/**
 *
 * @author Youri Dudock
 */
public abstract class InputComponent {
    
    private ArrayList<Component> components = new ArrayList(); // list with the components that belong with each other (like buttons)
    
    private static ButtonComponent buttonComponent = new ButtonComponent(); // the button component child
    
    private static PressurePlateComponent pressurePlateComponent = new PressurePlateComponent(); // the pressure plate component child
    
    public static void initialize() { // inits the childs and sets the component
        InputComponent.getButtonComponent().setComponents();
        InputComponent.getPressurePlateComponent().setComponents();
    }
    
    /**
     * Fills the component list with components of the same type (like buttons)
     */
    public void setComponents() {
        for (Component component : Component.values()) {
            
            if (component.toString().startsWith(getPrefix())) { // check if prefix matches
                components.add(component);
            }
            
        }
    }
    
    /**
     * Checks if the is any new input
     */     
    public void process() {
        for (Component component : components) {
            
            if (getState(component)) {
                component.doAction(); // if there is any new input perform the action with it
            }
            
        }
    }
    
    
    public abstract String getPrefix();
    
    public abstract boolean getState(Component component);
    
    public static ButtonComponent getButtonComponent() {
        return buttonComponent;
    }
    
    public static PressurePlateComponent getPressurePlateComponent() {
        return pressurePlateComponent;
    }
    
    public ArrayList<Component> getComponents() {
        return components;
    }
    
}
