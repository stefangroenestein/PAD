/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.input.button.impl;

import PAD.game.GameHandler;
import PAD.game.GameMode;
import PAD.interfaceKit.component.ComponentAction;

/**
 *
 * @author Youri Dudock
 */
public class GreenButtonAction implements ComponentAction {

    @Override
    public void trigger() {
        System.out.println("You have pressed the green button.");
        
        GameHandler.startGame(GameMode.NORMAL);
    }
    
}
