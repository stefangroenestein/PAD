/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.Main.debug;

/**
 * Deals with the debugging of info
 *
 * @author Youri
 */
public class Debugger {
    
    private static final boolean DEBUG = true; // if debug is on
    
    /**
     * Writes a string to the console
     * 
     * @param log 
     *          debug information
     */
    public static void write(String log) {
        if (DEBUG) {
            System.out.println("[DEBUG] " + log);
        }
    }
    
}
