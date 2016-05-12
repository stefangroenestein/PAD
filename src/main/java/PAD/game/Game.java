/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game;

import PAD.interfaceKit.component.LinkedComponent;

/**
 *
 * @author Youri Dudock
 */
public class Game {
    
    private GameMode mode; // the mode this game is in
    
    private GameStage stage = GameStage.FINISHED;
    
    private LinkedComponent releasedPiston; // the piston which has been released
    
    public void setGameMode(GameMode mode) {
        this.mode = mode;
    }
    
    public GameMode getMode() {
        return mode;
    }
    
    public GameStage getStage() {
        return stage;
    }
    
    public void setStage(GameStage stage) {
        this.stage = stage;
        
        System.out.println("Game set to stage: " + stage.toString());
    }
    
    public void setReleasedPiston(LinkedComponent component) {
        this.releasedPiston = component;
    }
    
    public LinkedComponent getReleasedPiston() {
        return releasedPiston;
    }
    
    
    
    
    
}
