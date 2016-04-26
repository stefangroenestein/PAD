/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main;

import PAD.game.GameHandler;
import PAD.game.GameMode;
import PAD.interfaceKit.KitConnector;
import PAD.sound.Sound;
import PAD.sound.Speaker;

/**
 *
 * @author Youri Dudock
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class Main {
    
    private static Controller controller = new Controller();

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        KitConnector.initialize();
        
        controller.start();
        
        
        
    }
}