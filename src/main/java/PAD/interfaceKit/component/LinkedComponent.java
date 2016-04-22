/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

/**
 * Contains two components (a magnet and a pressure plate) which are linked which each other
 *
 * @author Youri Dudock
 */
public enum LinkedComponent {
    
    ONE(Component.MAGNET_ONE, Component.PRESSURE_PLATE_ONE);
    
    private Component magnet;
    
    private Component plate;
    
    private LinkedComponent(Component magnet, Component plate) {
        this.magnet = magnet;
        this.plate = plate;
    }
    
    public Component getMagnet() {
        return magnet;
    }
    
    public Component getPressurePlate() {
        return plate;
    }
    
}
