/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input.button.impl;

import PAD.interfaceKit.component.ComponentAction;
import PAD.sound.Sound;
import PAD.sound.Speaker;

/**
 *
 * @author Admin
 */
public class WhiteButtonAction implements ComponentAction {

    @Override
    public void trigger() {
        System.out.println("You have pressed the white button.");
    }
    
}
