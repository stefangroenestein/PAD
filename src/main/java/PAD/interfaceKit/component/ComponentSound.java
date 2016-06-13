/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.component;

import PAD.sound.Sound;

/**
 * Links certain audio with a component
 *
 * @author Youri
 */
public enum ComponentSound {

    PISTON_ONE(Component.PRESSURE_PLATE_ONE, Sound.RHINO),
    PISTON_TWO(Component.PRESSURE_PLATE_TWO, Sound.BEAR),
    PISTON_THREE(Component.PRESSURE_PLATE_THREE, Sound.KOALA),
    PISTON_FOUR(Component.PRESSURE_PLATE_FOUR, Sound.LION),
    PISTON_FIVE(Component.PRESSURE_PLATE_FIVE, Sound.DOG);

    private Component component; // the component linked to this sound

    private Sound sound; // the sound linked to this component

    /**
     * 
     * @param component the component linked to the sound
     * @param sound the linked sound
     */
    private ComponentSound(Component component, Sound sound) {
        this.component = component;
        this.sound = sound;
    }

    /**
     *
     * @return the sound that belongs to this component
     */
    public Sound getSound() {
        return sound;
    }

}
