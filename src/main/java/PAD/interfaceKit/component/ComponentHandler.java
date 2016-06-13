/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

import PAD.main.debug.Debugger;
import PAD.interfaceKit.KitConnector;
import PAD.interfaceKit.io.IOType;
import PAD.interfaceKit.io.input.button.ButtonComponent;
import PAD.interfaceKit.io.input.pressure.PressurePlateComponent;
import PAD.interfaceKit.io.output.LED.LedComponent;
import PAD.interfaceKit.io.output.magnet.MagnetComponent;
import PAD.main.util.RandomUtil;
import com.phidgets.PhidgetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A super class for all the input & output components for this application a
 * new type of component should make use of this class
 *
 * @author Youri Dudock
 * @author Bobbie hondeveld
 */
public abstract class ComponentHandler {

    private ArrayList<Component> components = new ArrayList(); // list with the components that belong with each other, instanced for every type of input component

    private static ButtonComponent buttonComponent = new ButtonComponent(); // the button component child

    private static PressurePlateComponent pressurePlateComponent = new PressurePlateComponent(); // the pressure plate component child

    private static MagnetComponent magnetComponent = new MagnetComponent(); // the magnet component child

    private static LedComponent ledComponent = new LedComponent(); // the led component child

    /**
     * Inits the childs and sets the component in the parent
     */
    public static void initialize() {
        ComponentHandler.getButton().setComponents();
        ComponentHandler.getPressurePlate().setComponents();
        ComponentHandler.getMagnet().setComponents();
        ComponentHandler.getLed().setComponents();
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
     * Processes input by reading and processes output by setting
     *
     * @param type the type of IO
     */
    public void process(IOType type) {
        switch (type) {

            case INPUT:
                for (Component component : components) { // loops trough all the components that belong with this type of component

                    if (getState(component)) {
                        component.doAction(); // if there is any new input perform the action with it
                    }
                }
                break;

            case OUTPUT:
                while (ComponentQueue.hasNext()) { // checks if the queue has items left

                    try {
                        QueuedComponent queuedComponent = ComponentQueue.getNext(); // gets the next item in the queue

                        Debugger.write("Activate " + queuedComponent.getComponent().toString() + " / id: " + queuedComponent.getComponent().getId() + " / state " + queuedComponent.getState());

                        KitConnector.getKit().setOutputState(queuedComponent.getComponent().getId(), queuedComponent.getState()); // outputs the queued component

                    } catch (PhidgetException ex) {
                        Logger.getLogger(ComponentHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

        }
    }

    /**
     * Grabs a random linked component from our linked component enum
     *
     * @return a linked component
     */
    public static LinkedComponent getRandomLinkedComponent() {
        LinkedComponent linkedComponent = LinkedComponent.values()[(RandomUtil.getRandomInt(LinkedComponent.values().length))]; // gets a random int that is within the range of the size of the enum

        Debugger.write("Obtained a new linked component: " + linkedComponent.name());

        return linkedComponent;
    }

    /**
     * Gets the input state of a component
     *
     * @param component the component which is being read
     *
     * @return true if the component is being activated (triggered)
     */
    public boolean getState(Component component) {
        return false;
    }

    /**
     * Places the component and its new state to the queue for processing
     *
     * @param component the component which is being set
     *
     * @param state the new state of this component
     */
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
     *
     * @return the led component 'handler'
     */
    public static LedComponent getLed() {
        return ledComponent;
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
