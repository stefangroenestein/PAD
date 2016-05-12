/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game;

/**
 * The stages of a game
 *
 * @author Youri Dudock
 */
public enum GameStage {
    
    WAITING_FOR_PISTON, // waiting for the pistons to be pressed down
    RUNNING, // game is being played
    FINISHED; // game is done
    
}
