/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

/**
 * Contains two components (a magnet and a pressure plate) which are linked with
 * each other
 *
 * @author Youri Dudock
 */
public enum LinkedComponent {

    ONE(Component.MAGNET_ONE, Component.PRESSURE_PLATE_ONE),
    TWO(Component.MAGNET_TWO, Component.PRESSURE_PLATE_TWO),
    THREE(Component.MAGNET_THREE, Component.PRESSURE_PLATE_THREE),
    FOUR(Component.MAGNET_FOUR, Component.PRESSURE_PLATE_FOUR),
    FIVE(Component.MAGNET_FIVE, Component.PRESSURE_PLATE_FIVE);

    private Component magnet; // the magnet component

    private Component plate; // the pressure plate component

    /**
     *
     * @param magnet the magnet component
     * @param plate the pressure plate component
     */
    private LinkedComponent(Component magnet, Component plate) {
        this.magnet = magnet;
        this.plate = plate;
    }

    /**
     *
     * @return the magnet in this linked component
     */
    public Component getMagnet() {
        return magnet;
    }

    /**
     *
     * @return the pressure plate in this linked component
     */
    public Component getPressurePlate() {
        return plate;
    }

}
