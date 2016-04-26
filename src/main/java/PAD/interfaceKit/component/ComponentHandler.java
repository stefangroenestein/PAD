/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

import PAD.interfaceKit.KitConnector;
import PAD.interfaceKit.io.IOType;
import PAD.interfaceKit.io.input.button.ButtonComponent;
import PAD.interfaceKit.io.input.pressure.PressurePlateComponent;
import PAD.interfaceKit.io.output.magnet.MagnetComponent;
import PAD.main.util.RandomUtil;
import com.phidgets.PhidgetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A parent for all the input component, this class will progress and read input
 * components every new input component should extend this class in order to be
 * read
 *
 * @author Youri Dudock
 */
public abstract class ComponentHandler {

    private ArrayList<Component> components = new ArrayList(); // list with the components that belong with each other, instanced for every type of input component

    private static ButtonComponent buttonComponent = new ButtonComponent(); // the button component child

    private static PressurePlateComponent pressurePlateComponent = new PressurePlateComponent(); // the pressure plate component child

    private static MagnetComponent magnetComponent = new MagnetComponent();
    

    public static void initialize() { // inits the childs and sets the component
        ComponentHandler.getButton().setComponents();
        ComponentHandler.getPressurePlate().setComponents();
        ComponentHandler.getMagnet().setComponents();
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
    public void process(IOType type) {
        switch (type) {

            case INPUT:
                for (Component component : components) {

                    if (getState(component)) {
                        component.doAction(); // if there is any new input perform the action with it
                    }
                }
                break;

            case OUTPUT:
                while (ComponentQueue.hasNext()) {

                    try {
                        QueuedComponent queuedComponent = ComponentQueue.getNext();
                        KitConnector.getKit().setOutputState(queuedComponent.getComponent().getId(), queuedComponent.getState());

                    } catch (PhidgetException ex) {
                        Logger.getLogger(ComponentHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

        }

        for (Component component : components) {

            if (getState(component)) {
                component.doAction(); // if there is any new input perform the action with it
            }

        }
    }

    /**
     * Gets the input state of a component
     *
     * @param component the component which is being read
     *
     * @return true if the component is being activated
     */
    public boolean getState(Component component) {
        return false;
    }
    
    public static void setState(Component component, boolean state) {
        ComponentQueue.add(component, state);
    }

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
    public static ButtonComponent getButton() {
        return buttonComponent;
    }

    /**
     *
     * @return the pressure plate component 'handler'
     */
    public static PressurePlateComponent getPressurePlate() {
        return pressurePlateComponent;
    }

    /**
     *
     * @return the magnet component 'handler'
     */
    public static MagnetComponent getMagnet() {
        return magnetComponent;
    }

    /**
     * All the components for this input component
     *
     * @return a list with components of the same type
     */
    public ArrayList<Component> getComponents() {
        return components;
    }
    
    /**
     * Gets a random linked component
     * 
     * @return a random linked component
     */
    public static LinkedComponent getRandomLinkedComponent() {
         LinkedComponent[] linkedComponents = LinkedComponent.values();
         
         return linkedComponents[(RandomUtil.getRandomInt(linkedComponents.length))];
    }

}
