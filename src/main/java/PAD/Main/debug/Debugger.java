/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.Main.debug;

/**
 *
 * @author Youri
 */
public class Debugger {
    
    private static final boolean DEBUG = true;
    
    public static void write(String log) {
        if (DEBUG) {
            System.out.println("[DEBUG] " + log);
        }
    }
    
}
