/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game;

import PAD.Main.debug.Debugger;
import PAD.game.mechanic.PistonMechanic;
import PAD.interfaceKit.component.ComponentHandler;

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
        System.out.println("Starting a new game with game mode: " + mode.toString());

        if (game.getStage().equals(GameStage.FINISHED)) { // check if there isnt a active game
            game = new Game(); // create new

        } else if (!game.getStage().equals(GameStage.FINISHED)) {
            System.out.println("There is already a active game being played..");
            return;
        }

        PistonMechanic.getPistonsDown().clear(); // clean list for our pistonAreDown checker

        ComponentHandler.getMagnet().setMagnets(true); // turn all the magnets on

        game.setGameMode(mode); // sets the game mode for this game

        game.setStage(GameStage.WAITING_FOR_PISTON); // sets the game in the next game stage
    }

    /**
     * Proceses the game, this gets called every tick
     */
    public static void process() {
        switch (game.getStage()) {

            case WAITING_FOR_PISTON: // if the game is waiting for the pistons to be pressed down
                if (PistonMechanic.arePistonsDown()) {

                    game.getTimer().start(); // starts the timer

                    PistonMechanic.releasePiston(ComponentHandler.getRandomLinkedComponent()); // released a random piston

                    game.setStage(GameStage.RUNNING); // sets the stage to running
                } else {
                    System.out.println("Waiting for the pistons to be pressed down..");
                }
                break;

            case RUNNING:
                if (GameHandler.getGame().getReleasedPiston() != null) {
                    Debugger.write("Expecting piston: " + GameHandler.getGame().getReleasedPiston().getPressurePlate());
                }
                
                game.getMode().getHandler().onTick();
                break;

        }

    }

    /**
     * Stops the game
     */
    public static void stop() {
        game.setStage(GameStage.FINISHED); // sets the stage to finished

        game.getTimer().stop(); // stops the timer

        Debugger.write("Game has finished! Points: " + game.getPoints() + " Time played: " + game.getTimer().getSeconds() + " seconds");
    }

    /**
     * This gets called every tick, action depends on the mode of the game
     */
    public abstract void onTick();

    /**
     * This get called when a piston has been pressed down, default operation is
     * adding a point but this can be overwritten
     */
    public void onPistonDown() {
        game.increasePoints(); // increases the points
    }

    /**
     *
     * @return the game in this handler
     */
    public static Game getGame() {
        return game;
    }

}
