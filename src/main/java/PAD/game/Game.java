/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game;

import PAD.interfaceKit.component.Component;
import java.util.ArrayList;

/**
 *
 * @author Youri Dudock
 */
public class Game {
    
    private GameMode mode; // the mode this game is in
    
    private boolean isFinished = false;
    
    private boolean hasStarted = false;
    
    public void initialize() {
        hasStarted = true;
    }
    
    public void setGameMode(GameMode mode) {
        this.mode = mode;
    }
    
    public boolean isFinished() {
        return isFinished;
    }
    
    public boolean hasStarted() {
        return hasStarted;
    }
    
    
    
    
    
}
