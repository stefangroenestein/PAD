/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game.handlers;

import PAD.game.GameHandler;

/**
 *
 * @author Youri
 */
public class TimedGameHandler extends GameHandler {
    
    private final int GAME_TIME = 30;

    @Override
    public void onTick() {
        if (GameHandler.getGame().getTimer().getSeconds() >= GAME_TIME) {
            GameHandler.stop();
        }
    }
    
}
