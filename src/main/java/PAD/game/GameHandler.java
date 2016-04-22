/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game;

import PAD.game.mechanic.PistonMechanic;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.interfaceKit.io.input.InputComponent;
import PAD.interfaceKit.io.output.magnet.MagnetHandler;

/**
 * Handles a game and works as a base class for actual game modes
 *
 * @author Youri Dudock
 */
public abstract class GameHandler {

    private static Game game = new Game(); // a game, static because their can only exists one

    /**
     * Starts a new game
     *
     * @param mode the game mode of this game
     */
    public static void startGame(GameMode mode) {
        if (game.getStage().equals(GameStage.FINISHED)) { // check if there isnt a active game
            game = new Game(); // create new

        } else if (!game.getStage().equals(GameStage.FINISHED)) {
            System.out.println("There is already a active game being played..");
            return;
        }
        
        PistonMechanic.getPistonsDown().clear();

        MagnetHandler.setMagnets(true); // turn the magnets on

        game.setGameMode(mode); // sets the game mode for this game

        game.setStage(GameStage.WAITING_FOR_PISTON);
    }

    /**
     * Proceses the game, this gets called every tick
     */
    public static void process() {
        switch (game.getStage()) {

            case WAITING_FOR_PISTON:
                if (PistonMechanic.arePistonsDown()) {
                    System.out.println("Pistons are pressed down, moving to the next stage..");
                    
                    PistonMechanic.releasePiston(ComponentHandler.getRandomLinkedComponent());
                    game.setStage(GameStage.RUNNING);
                } else {
                    System.out.println("Waiting for the pistons to be pressed down..");
                }
                break;
                
            case RUNNING:
               
                break;

        }

    }
    
    /**
     *
     * @return the game in this handler
     */
    public static Game getGame() {
        return game;
    }

}
