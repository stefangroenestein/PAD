/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game.handlers;

import PAD.game.GameHandler;

/**
 * The handling of a timed game mode
 *
 * @author Youri
 */
public class TimedGameHandler extends GameHandler {
    
    private final int GAME_TIME = 30;

    @Override
    public void onTick() {
        
    }
    
    @Override
    public int getGameLength() {
        return GAME_TIME;
    }
    
}
