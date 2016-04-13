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
    
    private ArrayList<Component> components = new ArrayList();
    
    private static ButtonComponent buttonComponent = new ButtonComponent();
    
    private static PressurePlateComponent pressurePlateComponent = new PressurePlateComponent();
    
    public static void initialize() {
        InputComponent.getButtonComponent().setComponents();
        InputComponent.getPressurePlateComponent().setComponents();
    }
    
    public void setComponents() {
        for (Component component : Component.values()) {
            
            if (component.toString().startsWith(getPrefix())) {
                components.add(component);
            }
            
        }
    }
    
        
    public void process() {
        for (Component component : components) {
            
            if (getState(component)) {
                component.doAction();
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
