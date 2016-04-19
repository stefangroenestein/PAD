/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.game;

/**
 *
 * @author Youri Dudock
 */
public class GameHandler {
    
    private static Game game = new Game();
    
    public static void startGame(GameMode mode) {
        if (game.isFinished()) {
            game = new Game();
            
        } else if (!game.isFinished()) {
            System.out.println("There is already a active game being played..");
            return;
        }
        
        game.setGameMode(mode);
        
        game.initialize();
    }
    
    public static void process() {
        if (!game.hasStarted() || game.isFinished()) {
            return;
        }
        
        
        
        
        
        
    }
    
}
