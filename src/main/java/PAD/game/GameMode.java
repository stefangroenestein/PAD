/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game;

import PAD.game.handlers.NormalGameHandler;
import PAD.game.handlers.TimedGameHandler;

/**
 * The mode a game can have
 *
 * @author Youri Dudock
 */
public enum GameMode {
    
    NORMAL(new NormalGameHandler(), false), // this is a normal game without any timer that runs down (sandbox)
    TIMED_EASY(new TimedGameHandler(), true); // this is a mode which has a timer run down and you need to be as fast as possible
    
    private GameHandler handler; // the handler that handles this mode
    
    private boolean isTimed;
    
    /**
     * 
     * @param handler 
     */
    private GameMode(GameHandler handler, boolean isTimed) {
        this.handler = handler;
        this.isTimed = isTimed;
    }
    
    /**
     * 
     * @return instance of the handler for this mode
     */
    public GameHandler getHandler() {
        return handler;
    }
    
    public boolean isTimed() {
        return isTimed;
    }
    
    
}
