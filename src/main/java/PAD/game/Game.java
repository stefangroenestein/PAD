/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game;

import PAD.Main.Timer;
import PAD.Main.debug.Debugger;
import PAD.interfaceKit.component.LinkedComponent;

/**
 * Holds information about a current game that is being played
 *
 * @author Youri Dudock
 */
public class Game {

    private GameMode mode; // the mode this game is in

    private GameStage stage = GameStage.FINISHED; // the stage of the game

    private LinkedComponent releasedPiston; // the piston which has been released

    private Timer timer = new Timer(); // the timer in this game

    private int points = 0; // the points gained by the player

    /**
     * Sets the mode of the game
     *
     * @param mode
     */
    public void setGameMode(GameMode mode) {
        this.mode = mode;
    }

    /**
     *
     * @return mode of this game
     */
    public GameMode getMode() {
        return mode;
    }

    /**
     *
     * @return the stage of this game
     */
    public GameStage getStage() {
        return stage;
    }

    /**
     *
     * @return the timer of this game
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     *
     * @return the points gained by the player in this game
     */
    public int getPoints() {
        return points;
    }

    /**
     * increases the amount of points gained by the player (by 1)
     */
    public void increasePoints() {
        points++;
    }

    /**
     * Sets the stage of this game
     *
     * @param stage The new stage
     */
    public void setStage(GameStage stage) {
        this.stage = stage;

        Debugger.write("Game set to stage: " + stage.toString());
    }

    /**
     * Sets the new released piston
     *
     * @param component
     */
    public void setReleasedPiston(LinkedComponent component) {
        this.releasedPiston = component;
    }

    /**
     *
     * @return the released piston
     */
    public LinkedComponent getReleasedPiston() {
        return releasedPiston;
    }

}
