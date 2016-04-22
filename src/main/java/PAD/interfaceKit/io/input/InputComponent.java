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
 * A parent for all the input component, this class will progress and read input
 * components every new input component should extend this class in order to be
 * read
 *
 * @author Youri Dudock
 */
public abstract class InputComponent {

    private ArrayList<Component> components = new ArrayList(); // list with the components that belong with each other, instanced for every type of input component

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
     * Checks if there is any new input
     */
    public void process() {
        for (Component component : components) {

            if (getState(component)) {
                component.doAction(); // if there is any new input perform the action with it
            }

        }
    }
    
    /**
     * Gets the input state of a component
     * 
     * @param component
     *                the component which is being read
     * 
     * @return true if the component is being activated 
     */
    public abstract boolean getState(Component component);

    /**
     * Obtains the prefix to search for in the Component enum
     * 
     * @return a string used to find the component
     */
    public abstract String getPrefix();

    /**
     * 
     * @return the button component 'handler'
     */
    public static ButtonComponent getButtonComponent() {
        return buttonComponent;
    }

    /**
     * 
     * @return the pressure plate component 'handler'
     */
    public static PressurePlateComponent getPressurePlateComponent() {
        return pressurePlateComponent;
    }

    /**
     * All the components for this input component
     * 
     * @return a list with components of the same type
     */
    public ArrayList<Component> getComponents() {
        return components;
    }

}
