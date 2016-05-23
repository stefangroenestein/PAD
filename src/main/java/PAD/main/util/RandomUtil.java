/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main.util;

import java.util.ArrayList;
import java.util.Random;

/**
 * Contains function to handle random 
 *
 * @author Youri Dudock
 */
public class RandomUtil {
    
    private static Random randomGenerator = new Random(); // a random instance, static for the whole program
    
    /**
     * A random int from 0 to x
     * 
     * @param max
     *          the max range
     * 
     * @return a random int 
     */
    public static int getRandomInt(int max) {
        return randomGenerator.nextInt(max);
    }
    
    public static Object getRandomItem(ArrayList<?> list) {
        return list.get(randomGenerator.nextInt(list.size()));
    }
    
}
